package com.example.kppniisby.Main

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.kppniisby.Informasi.InfoActivity
import com.example.kppniisby.LPJ.LpjHomeActivity
import com.example.kppniisby.R
import com.example.kppniisby.SPM.SpmHomeActivity

class HomeActivity : AppCompatActivity() {
    lateinit var alertDialog: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val logout = findViewById<TextView>(R.id.logout)
        alertDialog = AlertDialog.Builder(this)
        logout.setOnClickListener {
            alertDialog.setTitle("Keluar Akun")
            alertDialog.setMessage("Apakah Anda Ingin Keluar Akun ?")
                    .setCancelable(false)
                    .setPositiveButton("YA", object: DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, id:Int) {
                            val intent = Intent(this@HomeActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    })
                    .setNegativeButton("TIDAK", object: DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, id:Int) {
                            dialog.cancel()
                        }
                    }).create().show()
        }
        val fab_info = findViewById<LinearLayout>(R.id.fab_info)
        fab_info.setOnClickListener {
            val goInfo = Intent(this@HomeActivity, InfoActivity::class.java)
            startActivity(goInfo)
            finish()
        }
        val fab_lpj = findViewById<CardView>(R.id.fab_lpj)
        fab_lpj.setOnClickListener {
            val golpj = Intent(this@HomeActivity, LpjHomeActivity::class.java)
            startActivity(golpj)
            finish()
        }
        val fab_spm = findViewById<CardView>(R.id.fab_spm)
        fab_spm.setOnClickListener {
            val gospm = Intent(this@HomeActivity, SpmHomeActivity::class.java)
            startActivity(gospm)
            finish()
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}