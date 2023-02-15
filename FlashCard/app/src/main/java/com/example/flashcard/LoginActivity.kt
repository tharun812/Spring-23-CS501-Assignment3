package com.example.flashcard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcard.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        binding.login.setOnClickListener(View.OnClickListener {
            if(username!=null && password!=null && username.text.toString().equals(getString(R.string.username)) && password.text.toString().equals(getString(R.string.password)))
            {
                showSnackBar("Successfully Logged in user")
                val myIntent = Intent(this@LoginActivity, QuizActivity::class.java)
                myIntent.putExtra("Username",username.text.toString())
                this.startActivity(myIntent)
                this.finish()
            }
            else{
                showSnackBar("Please enter valid Username and Password")
            }

        })

    }

    private fun showSnackBar(text: String) {
        Snackbar
            .make(
                binding.root,
                text,
                Snackbar.LENGTH_LONG
            ).show()
    }
}