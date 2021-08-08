package com.example.kppniisby.SPM

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kppniisby.Model.DatabaseSpm
import com.example.kppniisby.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.*

class ResultSpmActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var tgl: TextView
    lateinit var nmsatker: TextView
    lateinit var SPM: TextView
    lateinit var Status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_spm)

        tgl = findViewById(R.id.tv_tgl)
        nmsatker = findViewById(R.id.tv_nmsatker)
        SPM = findViewById(R.id.judulspm)
        Status = findViewById(R.id.status)
        databaseReference = FirebaseDatabase.getInstance().reference
        val query = databaseReference.child("Sheet1DATASPM")
                .orderByChild("id").equalTo(intent.getDoubleExtra("id", 0.0))
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(datasnapshot: DataSnapshot) {
                if (datasnapshot != null) {
                    for (snapshot1 in datasnapshot.children) {
                        val allocation = snapshot1.getValue(DatabaseSpm::class.java)
                        tgl.setText(allocation!!.tanggal)
                        nmsatker.setText(allocation.namasatker)
                        SPM.setText(allocation.SPM)
                        Status.setText(allocation.Status)
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    override fun onBackPressed() {
        val goHome = Intent(this@ResultSpmActivity, SpmHomeActivity::class.java)
        startActivity(goHome)
        finish()
    }
}