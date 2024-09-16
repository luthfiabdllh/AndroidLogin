package com.example.androidlogin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlogin.databinding.ActivityMainBinding
import com.example.androidlogin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val gender = intent.getStringExtra("gender")
        val username = intent.getStringExtra("username")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            edtEmail.setText(email)
            edtPassword.setText(password)

            btnSignup.setOnClickListener {
                val intentToSecondActivity =
                    Intent(this@SecondActivity, MainActivity::class.java)
                startActivity(intentToSecondActivity)
            }

            btnLogin.setOnClickListener{
                val intentToThirdActivity =
                    Intent(this@SecondActivity, ThirdActivity::class.java)
                intentToThirdActivity.putExtra("gender", gender)
                intentToThirdActivity.putExtra("username", username)
                startActivity(intentToThirdActivity)
            }
        }
    }
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}