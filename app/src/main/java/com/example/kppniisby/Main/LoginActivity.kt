package com.example.kppniisby.Main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kppniisby.Main.LoginActivity
import com.example.kppniisby.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var password: EditText
    lateinit var username: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        val btm_regist = findViewById<Button>(R.id.btm_regist)
        btm_regist.setOnClickListener {
            val goRegister = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(goRegister)
            finish()
        }
        val fab_login = findViewById<FloatingActionButton>(R.id.fab_login)
        fab_login.setOnClickListener {
            val uname = username.getText().toString()
            val pass = password.getText().toString()
            if (uname == "") {
                Toast.makeText(this@LoginActivity, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (pass == "") {
                Toast.makeText(this@LoginActivity, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(uname, pass)
                        .addOnCompleteListener(this@LoginActivity) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                val user = mAuth.getCurrentUser()
                                Toast.makeText(this@LoginActivity, "Authentication success.",
                                        Toast.LENGTH_SHORT).show()
                                val goHome = Intent(this@LoginActivity, HomeActivity::class.java)
                                startActivity(goHome)
                                finish()
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(this@LoginActivity, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                            }

                            // ...
                        }
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}