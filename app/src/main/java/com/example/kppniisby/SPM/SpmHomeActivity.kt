package com.example.kppniisby.SPM

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kppniisby.Main.HomeActivity
import com.example.kppniisby.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SpmHomeActivity : AppCompatActivity() {
    lateinit var username: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spm_home)

        username = findViewById(R.id.usernamespm)
        val searchspm = findViewById<FloatingActionButton>(R.id.fab_searchspm)
        searchspm.setOnClickListener {
            if(username.text.isNotEmpty()) {
                val gospmm = Intent(this@SpmHomeActivity, ResultSpmActivity::class.java)
                gospmm.putExtra("id", username.getText().toString().toDouble())
                startActivity(gospmm)
                finish()
            } else { Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show()}
        }
    }

    override fun onBackPressed() {
        val goHome = Intent(this@SpmHomeActivity, HomeActivity::class.java)
        startActivity(goHome)
        finish()
    }
}