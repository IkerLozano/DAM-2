package com.example.repaso1

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso1.databinding.ActivityDetailBinding

class DetailActivit2 : AppCompatActivity() {

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
            var nombre = datos.getString("nombre")
            var aterEgo = datos.getString("aterEgo")
            var Bio = datos.getString("Bio")
            var rating = datos.getFloat("rating")


            //los muestro
            binding.nombre.text = nombre
            binding.alterEgoResult.text = aterEgo
            binding.bioResult.text = Bio
            binding.poderResult.rating = rating


    }
}