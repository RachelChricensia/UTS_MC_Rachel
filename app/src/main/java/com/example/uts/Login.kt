package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uts.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

//        binding.signUp.setOnClickListener{
//            val intentDaftarakun = Intent(this, Daftarakun::class.java)
//            startActivity(intentDaftarakun)
//            finish()
//        }
//
//        binding.forgotPassword.setOnClickListener{
//            val intentResetpass = Intent(this, Resetpass::class.java)
//            startActivity(intentResetpass)
//            finish()
//        }
//        binding.loginButton.setOnClickListener{
//            val intentMainActivity = Intent(this, MainActivity::class.java)
//            startActivity(intentMainActivity)
//            finish()

        binding.loginButton.setOnClickListener {
            val email: String = binding.email.text.toString().trim()
            val password: String = binding.password.text.toString().trim()

            if (email.isEmpty()) {
                binding.email.error = "Input Email"
                binding.email.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.email.error = "Input Email"
                binding.email.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 6) {
                binding.password.error = "Password harus lebih dari 6 karakter"
                binding.password.requestFocus()
                return@setOnClickListener
            }
            loginUser(email,password)
        }
        binding.signUp.setOnClickListener {
            startActivity(Intent(this, Daftarakun::class.java))
        }
        binding.forgotPassword.setOnClickListener {
            Intent(this, Resetpass::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun loginUser(email: String, password: String) {
    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
        if (it.isSuccessful){
            Intent(this,MainActivity::class.java).also {
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
