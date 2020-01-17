package com.example.clearmvvmforapicallwithrxjava.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clearmvvmforapicallwithrxjava.R
import com.example.clearmvvmforapicallwithrxjava.baseClasses.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TodoFragment()).commit()
        }
    }
}
