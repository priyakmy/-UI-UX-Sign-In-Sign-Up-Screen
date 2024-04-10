package com.example.login_page

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity()
{
    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v , insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left , systemBars.top , systemBars.right , systemBars.bottom)
            insets
        }

        usernameEditText = findViewById<EditText>(R.id.textName)
        emailEditText = findViewById<EditText>(R.id.textEmail)
        passwordEditText = findViewById<EditText>(R.id.textPassword)
        loginButton = findViewById<Button>(R.id.btnLogin)
        // Set click listener for the login button
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if username and password are correct (for demo, let's assume some hardcoded values)
            if (username == "admin" && password == "password")
            {
                // If credentials are correct, navigate to another activity (e.g., MainActivity)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Close the login activity so the user can't navigate back to it
            } else
            {
                // If credentials are incorrect, display a toast message
                Toast.makeText(this , "Invalid username or password" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}