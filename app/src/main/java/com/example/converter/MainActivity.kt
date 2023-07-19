package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 :Button= findViewById(R.id.button)
        val firstFragment = FirstFragment()

        val btn2: Button = findViewById(R.id.Frag2Btn)
        val secondFragment = SecondFragment()

        val thirdFragment = ThirdFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FLfragment, thirdFragment)
            commit()
        }

        btn1.setOnClickListener { view->
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment, firstFragment)
                commit()
            }
        }
        btn2.setOnClickListener { view->
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment, secondFragment)
                commit()
            }
        }




    }
}