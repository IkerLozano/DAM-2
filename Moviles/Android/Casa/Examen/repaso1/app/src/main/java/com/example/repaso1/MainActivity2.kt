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

class MainActivity2 : AppCompatActivity() {

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


        //al pulsar el boton
        binding.botonGuardar.setOnClickListener {


            //recojo los datos
            val nombre = binding.editTextNombre.text.toString()
            val aterEgo = binding.editTextAterEgo.text.toString()
            val Bio = binding.editTextResumenBio.text.toString()
            val rating = binding.rating.rating


            // indico aq activity voy
            val intent = Intent(this, DetailActivity::class.java)


            //guardo los datos en el intent
            intent.putExtra("nombre", nombre)
            intent.putExtra("aterEgo", aterEgo)
            intent.putExtra("Bio", Bio)
            intent.putExtra("rating", rating)


            //inicio el intent
            startActivity(intent)





        }


    }
}