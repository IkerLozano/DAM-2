package com.example.pruebas2

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.Telephony
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import com.example.pruebas2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //1.lateinit: indica que la variable se inicializará más adelante, no en el momento de declararla.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //2.aquí creamos el objeto binding que nos permitirá acceder a los elementos de nuestro XML.
        binding = ActivityMainBinding.inflate(layoutInflater)

        //3. Mostramos la interfaz
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //Desde aqui empieza la parte funcional


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

            // 3.1 Leer los datos de las vistas
            val nombreSuperHeroe = binding.editTextNombreSuper.text.toString()
            val alterEgo = binding.editTextAlterEgo.text.toString()
            val textoBio = binding.editTextDebajodelBIO.text.toString()
            val estrellas = binding.estrellas.rating   // Float
            /*
                el .text, sirve para obtener el contenido de texto de un EditText
                y el toString(), convierte ese contenido en un String normal de Kotlin.

                en caso de las estrellas como no es texto ponemos rating
             */

            // 3.2 Crear el Intent: desde aquí (this) hasta DetailActivity2
            val intent = Intent(this, DetailActivity2::class.java)
            /*
               this → indica la Activity actual, es decir, desde dónde estamos.
               DetailActivity2::class.java → indica la Activity a la que queremos ir.
               val intent → guardamos ese Intent en una variable llamada intent.

               En este caso: "Quiero ir desde la Activity actual hasta DetailActivity2
           */

            // 3.3 Meter los datos: putExtra("clave", valor)
            intent.putExtra("nombreSuperHeroe", nombreSuperHeroe)
            intent.putExtra("alterEgo", alterEgo)
            intent.putExtra("textoBio", textoBio)
            intent.putExtra("estrellas", estrellas)
            intent.putExtra("foto", fotoBitmap)
            /*
               Intent → permite pasar de una Activity a otra y enviar datos entre ellas.
               putExtra() → añade datos al Intent para enviarlos a la otra Activity

               name = es la clave con la que identificaremos el dato
               value = es el valor que queremos enviar
           */
            // 3.4 Lanzar la otra Activity
            startActivity(intent)
        }

    }

}