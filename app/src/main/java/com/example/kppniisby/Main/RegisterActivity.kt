package com.example.kppniisby.Main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kppniisby.Main.RegisterActivity
import com.example.kppniisby.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var ed_email: EditText
    lateinit var ed_pass: EditText
    lateinit var kdsatker: EditText
    lateinit var ed_nama: EditText
    lateinit var ed_tlp: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()
        ed_email = findViewById(R.id.ed_email)
        ed_pass = findViewById(R.id.ed_pass)
        kdsatker = findViewById(R.id.kdsatker)
        ed_nama = findViewById(R.id.ed_nama)
        ed_tlp = findViewById(R.id.ed_tlp)
        val btm_login = findViewById<Button>(R.id.btm_login)
        btm_login.setOnClickListener {
            val goLogin = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(goLogin)
            finish()
        }
        val fab_regist = findViewById<FloatingActionButton>(R.id.fab_regist)
        fab_regist.setOnClickListener {
            val email = ed_email.getText().toString()
            val password = ed_pass.getText().toString()
            val kodesatker = kdsatker.getText().toString()
            val nama = ed_nama.getText().toString()
            val telepon = ed_tlp.getText().toString()
            if (email == "") {
                Toast.makeText(this@RegisterActivity, "Email tidak boleh kosong!",
                        Toast.LENGTH_SHORT).show()
            } else if (password == "") {
                Toast.makeText(this@RegisterActivity, "Password tidak boleh kosong!",
                        Toast.LENGTH_SHORT).show()
            } else if (kodesatker == "") {
                Toast.makeText(this@RegisterActivity, "Kode Satker tidak boleh kosong!",
                        Toast.LENGTH_SHORT).show()
            } else if (nama == "") {
                Toast.makeText(this@RegisterActivity, "Nama Satker tidak boleh kosong!",
                        Toast.LENGTH_SHORT).show()
            } else if (telepon == "") {
                Toast.makeText(this@RegisterActivity, "No. Telepon tidak boleh kosong!",
                        Toast.LENGTH_SHORT).show()
            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this@RegisterActivity) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                val user = mAuth.getCurrentUser()
                                Toast.makeText(this@RegisterActivity, "Authentication success.",
                                        Toast.LENGTH_SHORT).show()
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(this@RegisterActivity, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                            }
                        }
            }
        }
    }

    override fun onBackPressed() {
        val goLogin = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(goLogin)
        finish()
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
    }
}