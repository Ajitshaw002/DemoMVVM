package com.example.demoviewmodel


import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import androidx.annotation.NonNull
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.recyclerview_layout.view.*


class HeroesAdapter( var mCtx: Context,  var heroList: List<Hero>) :
    RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false))

    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val (name, realname, team, firstappearance, createdby, publisher, imageurl, bio) = heroList[position]
        Glide.with(mCtx)
            .load(imageurl)
            .into(holder.imageView)

        holder.textView.text = name
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

     inner class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView=itemView.imageView
        var textView=itemView.textView

    }
}