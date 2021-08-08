package com.example.kppniisby.LPJ

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kppniisby.LPJ.LpjHomeActivity
import com.example.kppniisby.Main.HomeActivity
import com.example.kppniisby.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class LpjHomeActivity : AppCompatActivity() {
    lateinit var username: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lpj_home)

        username = findViewById(R.id.usernamelpj)
        val searchlpj = findViewById<FloatingActionButton>(R.id.fab_searchlpj)
        searchlpj.setOnClickListener {
            if(username.text.isNotEmpty()) {
                val golpjj = Intent(this@LpjHomeActivity, ResultLpjActivity::class.java)
                golpjj.putExtra("id", username.getText().toString().toDouble())
                startActivity(golpjj)
                finish()
            } else { Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show()}
        }
    }

    override fun onBackPressed() {
        val goHome = Intent(this@LpjHomeActivity, HomeActivity::class.java)
        startActivity(goHome)
        finish()
    }
}