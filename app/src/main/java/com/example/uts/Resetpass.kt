package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uts.databinding.ActivityResetpassBinding
import com.google.firebase.auth.FirebaseAuth

class Resetpass : AppCompatActivity() {
    private lateinit var binding: ActivityResetpassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resetpass)

        binding = ActivityResetpassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.reset.setOnClickListener{
            val email : String = binding.emailForgot.text.toString().trim()
            if (email.isEmpty()){
                binding.emailForgot.error = "Input Email"
                binding.emailForgot.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.emailForgot.error = "Invalid Email"
                binding.emailForgot.requestFocus()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "cek email untuk reset password", Toast.LENGTH_SHORT).show()
                    Intent(this,Login::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
                else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}