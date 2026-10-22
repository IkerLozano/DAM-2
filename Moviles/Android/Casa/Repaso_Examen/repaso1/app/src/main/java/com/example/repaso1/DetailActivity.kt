package com.example.repaso1

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso1.databinding.ActivityDetailBinding

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


        //Recojo los datos
        val datos = intent.extras!!


        //sacamos los datos
        val nombreSuper = datos.getString("nombreSuper").takeUnless { it.isNullOrBlank() } ?: "No hay nombre"
        val alterEgo = datos.getString("alterEgo").takeUnless { it.isNullOrBlank() } ?: "No hay alter Ego"
        val resumenBio = datos.getString("resumenBio").takeUnless { it.isNullOrBlank() } ?: "No hay bio"
        val rating = datos.getFloat("rating")
        val foto = intent.getParcelableExtra<Bitmap>("foto")

        //muestro los datos por pantalla
        binding.nombre.text = nombreSuper
        binding.alterEgoResult.text = alterEgo
        binding.bioResult.text = resumenBio
        binding.poderResult.rating = rating
        binding.imageView.setImageBitmap(foto)
    }
}