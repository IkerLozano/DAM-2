package com.example.repaso3

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso3.databinding.ActivityDetailBinding
import com.example.repaso3.databinding.ActivitySuperheroesDatailBinding
import com.example.repaso3.databinding.ActivitySuperheroesMainBinding

class Superheroes_Datail : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroesDatailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySuperheroesDatailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //aqui empieza el codigo


        //Recojo los datos
        val datosRecibidos = intent.extras!!


        //Saco los datos
        val nombreSuperHeroe = datosRecibidos.getString("nombreSuperHeroe") ?: "No hay nombre"
        val alterEgo = datosRecibidos.getString("alterEgo") ?: "No hay alter ego"
        val textoBio = datosRecibidos.getString("textoBio") ?: "No hay bio"
        val estrellas = datosRecibidos.getFloat("estrellas")
        val foto = intent.getParcelableExtra<Bitmap>("foto")


        //Muestro los datos
        binding.nombreSuper.text = nombreSuperHeroe
        binding.alterEgoResult.text = alterEgo
        binding.bioResultado.text = textoBio
        binding.estrellasResultado.rating = estrellas
        binding.foto2.setImageBitmap(foto)
    }
}