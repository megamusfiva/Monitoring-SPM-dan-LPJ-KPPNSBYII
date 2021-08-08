package com.example.kppniisby.Informasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kppniisby.Informasi.KontakActivity
import com.example.kppniisby.R

class KontakActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kontak)
    }

    override fun onBackPressed() {
        val goinfoo = Intent(this@KontakActivity, InfoActivity::class.java)
        startActivity(goinfoo)
        finish()
    }
}