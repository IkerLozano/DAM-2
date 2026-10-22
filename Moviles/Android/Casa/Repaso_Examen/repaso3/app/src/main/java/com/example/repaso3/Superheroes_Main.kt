package com.example.repaso3

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso3.databinding.ActivityDetailBinding
import com.example.repaso3.databinding.ActivitySuperheroesMainBinding
import kotlin.toString

class Superheroes_Main : AppCompatActivity() {
    
    private lateinit var binding: ActivitySuperheroesMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySuperheroesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //empeiza el codigo

        // Aquí guardo la foto para poder mandarla luego
        var fotoBitmap: Bitmap? = null

        val camaraLauncher = registerForActivityResult(
            ActivityResultContracts.TakePicturePreview()
        ) { bitmap ->
            if (bitmap != null) {
                fotoBitmap = bitmap                    // la guardo
                binding.foto.setImageBitmap(bitmap)    // la muestro
            }
        }

        binding.foto.setOnClickListener {
            camaraLauncher.launch(null)
        }


        // 3. Al hacer clic en el botón
        binding.botonGuardar.setOnClickListener {

            //Recojo los datos
            val nombreSuperHeroe = binding.editTextNombreSuper.text.toString()
            val alterEgo = binding.editTextAlterEgo.text.toString()
            val textoBio = binding.editTextDebajodelBIO.text.toString()
            val estrellas = binding.estrellas.rating   // Float


            // Digo a que activity voy
            val intent = Intent(this, Superheroes_Datail::class.java)


            //Meto los dats en el intent
            intent.putExtra("nombreSuperHeroe", nombreSuperHeroe)
            intent.putExtra("alterEgo", alterEgo)
            intent.putExtra("textoBio", textoBio)
            intent.putExtra("estrellas", estrellas)
            intent.putExtra("foto", fotoBitmap)



            // Inicio el intent
            startActivity(intent)
        }
    }
}