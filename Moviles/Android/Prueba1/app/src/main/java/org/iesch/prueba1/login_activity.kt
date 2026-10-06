package org.iesch.prueba1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Telephony
import android.view.LayoutInflater
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.prueba1.databinding.HomeActivityBinding
import org.iesch.prueba1.databinding.LoginActivityBinding

class login_activity : AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Parte funcinal
        binding.botonLogin.setOnClickListener{
            val intent = Intent(this, home_activity::class.java)

            intent.putExtra("usuario", binding.editTextLogin.text.toString())
            startActivity(intent)
        }


    }
}