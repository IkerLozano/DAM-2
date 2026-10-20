package com.example.repaso3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso3.databinding.ActivityDetailBinding

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
        var nombreMascota = datos.getString("nombreMascota")
        var edadMascota = datos.getInt("edadMascota")
        val edadHumana = datos.getInt("edadHumana")
        var rating = datos.getFloat("rating")


        //los muestro
        binding.nombreResult.text = nombreMascota
        binding.textoResult.text = getString(R.string.personalizado, edadHumana)
        binding.ratingResult.rating = rating


        //vuelvo con el boton
        binding.botonVolver.setOnClickListener {

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}