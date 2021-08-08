package com.example.kppniisby.LPJ

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kppniisby.LPJ.ResultLpjActivity
import com.example.kppniisby.Model.DatabaseLpj
import com.example.kppniisby.R
import com.google.firebase.database.*

class ResultLpjActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var tgl: TextView
    lateinit var nmsatker: TextView
    lateinit var LPJKeluar: TextView
    lateinit var LPJTerima: TextView
    lateinit var BAKR: TextView
    lateinit var RK: TextView
    lateinit var SRB: TextView
    lateinit var KSS: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_lpj)
        tgl = findViewById(R.id.tv_tgllpj)
        nmsatker = findViewById(R.id.tv_nmsatkerlpj)
        LPJKeluar = findViewById(R.id.tv_LPJKeluar)
        LPJTerima = findViewById(R.id.tv_LPJTerima)
        BAKR = findViewById(R.id.tv_BAKR)
        RK = findViewById(R.id.tv_RK)
        SRB = findViewById(R.id.tv_SRB)
        KSS = findViewById(R.id.tv_KSS)
        databaseReference = FirebaseDatabase.getInstance().reference
        val query = databaseReference.child("Sheet1DATALPJ")
                .orderByChild("id").equalTo(intent.getDoubleExtra("id", 0.0))
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(datasnapshot: DataSnapshot) {
                if (datasnapshot != null) {
                    for (snapshot1 in datasnapshot.children) {
                        val allocation = snapshot1.getValue(DatabaseLpj::class.java)
                        tgl.text = allocation!!.Date
                        nmsatker.text = allocation.namasatker
                        LPJKeluar.text = allocation.LPJKeluar
                        LPJTerima.text = allocation.LPJTerima
                        BAKR.text = allocation.BAKR
                        RK.text = allocation.RK
                        SRB.text = allocation.SRB
                        KSS.text = allocation.KSS
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    override fun onBackPressed() {
        val goHome = Intent(this@ResultLpjActivity, LpjHomeActivity::class.java)
        startActivity(goHome)
        finish()
    }
}