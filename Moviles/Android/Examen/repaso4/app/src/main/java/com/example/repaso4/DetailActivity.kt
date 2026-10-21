package com.example.repaso4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //empieza el codigo

        //recojo los datos
        var datos = intent.extras!!


        //los saco
        var usuario = datos.getString("usuario")
        var contrasena = datos.getString("contrasena")


        //los muestro
        binding.textoSaludo.text = getString(R.string.Saludo,usuario )


        //al darle a la card de reservar
        binding.reservar.setOnClickListener {


            var intent = Intent(this, UsuarioMainActivity::class.java)
            startActivity(intent)

        }
    }
}