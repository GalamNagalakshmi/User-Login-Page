package com.example.task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, LoginFragment())
            transaction.commit()
        }

    }
}

