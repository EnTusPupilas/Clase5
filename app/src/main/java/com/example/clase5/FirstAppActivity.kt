package com.example.clase5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.firebase.analytics.FirebaseAnalytics

private lateinit var analytics: FirebaseAnalytics


class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics = FirebaseAnalytics.getInstance(this)
        setContentView(R.layout.activity_first_app)





    }
}
