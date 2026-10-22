package com.example.repaso3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso3.databinding.ActivityDetailBinding
import com.example.repaso3.databinding.ActivityMainBinding

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


        //al pulsar el boton
        binding.botonGuardar.setOnClickListener {


            //recojo los datos
            var nombreMascota = binding.editTextNombre.text.toString()
            var edadMascota = binding.editTextEdad.text.toString()
            var rating = binding.rating.rating


            //con ifs compruebo si los campos estan vacios
            if (nombreMascota.isEmpty() && edadMascota.isEmpty()){

                Toast.makeText(this, "El nombre y la edad estan vacios", Toast.LENGTH_LONG).show()
                return@setOnClickListener

            }else if (nombreMascota.isEmpty()){

                Toast.makeText(this, "El nombre de las moscota esta vacio", Toast.LENGTH_LONG).show()
                return@setOnClickListener

            }else if(edadMascota.toString().isEmpty()){

                Toast.makeText(this, "La edad esta vacia", Toast.LENGTH_LONG).show()
                return@setOnClickListener

            }

            //calculo la edad humana
            var edadHumana = edadMascota.toInt()*7


            //digo a que activity voy
            var intent = Intent(this, DetailActivity::class.java)


            //meto cada dato en el intent
            intent.putExtra("nombreMascota", nombreMascota)
            intent.putExtra("edadMascota", edadMascota)
            intent.putExtra("edadHumana", edadHumana)
            intent.putExtra("rating", rating)


            //activo el intent
            startActivity(intent)


        }


        //al pulsar la card roja
        binding.pulsar1.setOnClickListener {

            var intent = Intent(this, Superheroes_Main::class.java)
            startActivity(intent)

        }


    }
}