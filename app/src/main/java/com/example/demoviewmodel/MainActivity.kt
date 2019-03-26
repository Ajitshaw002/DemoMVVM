package com.example.demoviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders



class MainActivity : AppCompatActivity(), LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.layoutManager= LinearLayoutManager(this)

        val model = ViewModelProviders.of(this).get(HeroesViewModel::class.java)

        model.getHeroes().observe(this, object : Observer<List<Hero>> {
            override fun onChanged(@Nullable heroList: List<Hero>) {
                var adapter = HeroesAdapter(this@MainActivity, heroList)
                recyclerview.setAdapter(adapter)
            }
        })
    }
}
