package com.example.kppniisby.Informasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kppniisby.Informasi.DetailActivity
import com.example.kppniisby.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)
    }

    override fun onBackPressed() {
        val goinfoo = Intent(this@DetailActivity, InfoActivity::class.java)
        startActivity(goinfoo)
        finish()
    }
}