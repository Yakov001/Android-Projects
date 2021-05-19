package com.playground.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.playground.R

class ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container_main)

        if (fragment == null){
            fragment = FragmentMain()
            fm.beginTransaction().add(R.id.fragment_container_main, fragment).commit()
        }

        Log.d(FragmentMain.TAG , "onCreate(Activity)")
    }

}