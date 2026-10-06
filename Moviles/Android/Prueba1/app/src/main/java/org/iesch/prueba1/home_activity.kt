package org.iesch.prueba1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.prueba1.databinding.HomeActivityBinding

class home_activity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val datosRecibidos = intent.extras!!


        val nombre = datosRecibidos.getString("usuario")

        binding.textView.text = getString(R.string.mensajePersonalizado2, nombre)

        //cuando se pulse en boton del perro se ira a su aplcacion
        binding.imagePerro.setOnClickListener {
            startActivity(Intent(this, edad_canina_activity::class.java))
        }


        //cuando se pulse en boton de superheoes se ira a su aplcacion
        binding.imagenSuper.setOnClickListener {
            startActivity(Intent(this, superheroes_main_activity::class.java))
        }


    }
}