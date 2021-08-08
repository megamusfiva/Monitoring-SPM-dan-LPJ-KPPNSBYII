package com.example.kppniisby.Informasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kppniisby.Informasi.TentangActivity
import com.example.kppniisby.R

class TentangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)
    }

    override fun onBackPressed() {
        val goinfoo = Intent(this@TentangActivity, InfoActivity::class.java)
        startActivity(goinfoo)
        finish()
    }
}