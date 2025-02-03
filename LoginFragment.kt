package com.example.task2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        editTextUsername = view.findViewById(R.id.editTextUsername)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        buttonSubmit = view.findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(activity, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (username == "naga" && password == "1234") {
                Toast.makeText(activity, "Login successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, DashboardActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }

        }

        return view
    }
}
