package com.example.pruebas2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import com.example.pruebas2.databinding.ActivityDetailBinding

class DetailActivity2 : AppCompatActivity() {

    //1.lateinit: indica que la variable se inicializará más adelante, no en el momento de declararla.
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //2.aquí creamos el objeto binding que nos permitirá acceder a los elementos de nuestro XML.
        binding = ActivityDetailBinding.inflate(layoutInflater)

        //3. Mostramos la interfaz
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Desde aqui empeiza la parte funcional



    //3. recogemos los datos que enviamos desde la primera Activity

        val datosRecibidos = intent.extras!!

        /*
            intent → es el Intent con el que hemos llegado a esta Activity.
            .extras → contiene los datos que enviamos con putExtra().
            !! → indica que estamos seguros de que existen esos datos.
            datosRecibidos → es la variable donde guardamos todos esos datos.
         */


        //Sacmos de "datosRecibidos" cada uno de los datos
        val nombreSuperHeroe = datosRecibidos.getString("nombreSuperHeroe") ?: "No hay nombre"
        val alterEgo = datosRecibidos.getString("alterEgo") ?: "No hay alter ego"
        val textoBio = datosRecibidos.getString("textoBio") ?: "No hay bio"
        val estrellas = datosRecibidos.getFloat("estrellas")

        /*
            getString() → obtiene un dato que es de tipo String.
            "superHeroName" → es la clave que utilizamos cuando enviamfos el dato (tiene que se el mismo nombre)
         */


        //mostramos los datos por pantalla
        binding.nombreSuper.text = nombreSuperHeroe
        /*
            Mete el contenido de nombreSuperHeroe dentro del TextView cuyo ID es nombreSuper.
         */
        binding.alterEgoResult.text = alterEgo
        binding.bioResultado.text = textoBio
        binding.estrellasResultado.rating = estrellas
    }
}