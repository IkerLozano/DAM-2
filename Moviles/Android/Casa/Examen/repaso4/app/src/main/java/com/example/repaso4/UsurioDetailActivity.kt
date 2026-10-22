package com.example.repaso4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso4.databinding.ActivityDetailBinding
import com.example.repaso4.databinding.ActivityUsurioDetailBinding

class UsurioDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsurioDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUsurioDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //aqui empieza el codigo


        //recojo los datos
        var datos = intent.extras!!


        //los saco
        var nombre = datos.getString("nombre").takeUnless { it.isNullOrBlank() } ?: "No hay nombre"
        var noches = datos.getString("noches")
        var rating = datos.getFloat("rating")
        var precioT = intent.getFloatExtra("precioT", -1f)
        var foto = datos.getInt("foto")


        //los muestro
        binding.nombreResult.text = nombre
        binding.nochesResult.text = getString(R.string.Noches2, noches)
        binding.textoResult.text = getString(R.string.personalizado, precioT)
        binding.ratingResult.rating = rating
        binding.fotoResult.setImageResource(foto)


        //al pulsar el boton volver
        binding.botonVolver.setOnClickListener {

            var intent = Intent(this, UsuarioMainActivity::class.java)
            startActivity(intent)

        }

    }


}