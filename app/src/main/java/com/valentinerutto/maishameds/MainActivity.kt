package com.valentinerutto.maishameds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.valentinerutto.maishameds.databinding.ActivityMainBinding
//what we would like is an Android Activity that hits the /posts endpoint of https://jsonplaceholder.typicode.com/ and creates a new post.
//This activity should allow users to input the content of the post.

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnclickListener()

    }

    private fun setOnclickListener(){

        binding.fabPost.setOnClickListener {

        }

    }

}