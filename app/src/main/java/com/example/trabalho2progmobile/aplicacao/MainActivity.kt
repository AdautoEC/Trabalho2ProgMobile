 package com.example.trabalho2progmobile.aplicacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.trabalho2progmobile.R
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}