package com.example.repaso1

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //empieza el codigo

        //al pulsar la camara
        var foto: Bitmap? = null

        val camara = registerForActivityResult(
            ActivityResultContracts.TakePicturePreview()
        ) {bitmap ->
            if (bitmap !=null) {
                foto = bitmap
                binding.foto.setImageBitmap(bitmap)
            }

        }

        binding.foto.setOnClickListener {
            camara.launch(null)
        }



        //al pulsar en el boton
        binding.botonGuardar.setOnClickListener {

            //recogo los datos
            val nombreSuper = binding.editTextNombre.text.toString()
            val alterEgo = binding.editTextAterEgo.text.toString()
            val resumenBio = binding.editTextResumenBio.text.toString()
            val rating = binding.rating.rating


            //Indicar a qué pantalla queremos ir
            val intent = Intent(this, DetailActivity::class.java)


            //Guardar cada dato en el Intent con su clave
            intent.putExtra("nombreSuper", nombreSuper)
            intent.putExtra("alterEgo", alterEgo)
            intent.putExtra("resumenBio", resumenBio)
            intent.putExtra("rating", rating)
            intent.putExtra("foto", foto)


            //Ejecutar el Intent: ir a la otra pantalla
            startActivity(intent)
        }



    }
}