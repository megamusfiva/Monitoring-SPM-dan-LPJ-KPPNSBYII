package com.example.kppniisby.Informasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.kppniisby.Informasi.InfoActivity
import com.example.kppniisby.Main.HomeActivity
import com.example.kppniisby.R

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val akun = findViewById<CardView>(R.id.akun1)
        akun.setOnClickListener {
            val gotentang = Intent(this@InfoActivity, TentangActivity::class.java)
            startActivity(gotentang)
            finish()
        }
        val akun22 = findViewById<CardView>(R.id.akun2)
        akun22.setOnClickListener {
            val gokontak = Intent(this@InfoActivity, KontakActivity::class.java)
            startActivity(gokontak)
            finish()
        }
        val akun33 = findViewById<CardView>(R.id.akun3)
        akun33.setOnClickListener {
            val godetail = Intent(this@InfoActivity, DetailActivity::class.java)
            startActivity(godetail)
            finish()
        }
    }

    override fun onBackPressed() {
        val goinfoo = Intent(this@InfoActivity, HomeActivity::class.java)
        startActivity(goinfoo)
        finish()
    }
}