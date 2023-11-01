package com.example.clase5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth


private lateinit var analytics: FirebaseAnalytics


class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics = FirebaseAnalytics.getInstance(this)
        setContentView(R.layout.activity_first_app)

        setup()
    }

    private fun setup() {
        val btnEntrar = findViewById<AppCompatButton>(R.id.btnEntrar)
        val etName = findViewById<AppCompatEditText>(R.id.etName)
        val etPassword = findViewById<AppCompatEditText>(R.id.etPassword)
        btnEntrar.setOnClickListener {
            if (etName.text.toString().isNotEmpty() && etPassword.text.toString().isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    etName.text.toString(),
                    etPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, ResultActivity::class.java)
                        startActivity(intent)
                    } else {
                        val toast = Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT)
                        toast.show()
                    }
                }
            }
        }
    }
}
