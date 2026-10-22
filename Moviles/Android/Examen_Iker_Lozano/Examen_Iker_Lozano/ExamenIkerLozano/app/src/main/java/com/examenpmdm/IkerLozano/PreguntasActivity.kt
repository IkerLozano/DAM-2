package com.examenpmdm.IkerLozano

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.examenpmdm.IkerLozano.databinding.ActivityPreguntasBinding

class PreguntasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreguntasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPreguntasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //aqui comienza el codigo


        //cojo los datos
        var pregunta = binding.Pregunta.text


        //indico a que activity voy
        var intent = Intent(this, RespuestasActivity::class.java)


        //meto los datos en el intent
        intent.putExtra("pregunta", pregunta)


        //segun que pregunta sea muestro una u otra
        var cont = 1
        var datos = intent.extras!! //recibo los datos de las respuestas
        cont = intent.getIntExtra("cont", 0) //recibo los datos



        if (cont == 1){
            binding.Pregunta.text = "Pregunta 1"

        }else if(cont == 2){
            binding.Pregunta.text = "Pregunta 2"

        }else if (cont == 3){
            binding.Pregunta.text = "Pregunta 3"
        }



        //lo meto en el intent y los envio
        intent.putExtra("pregunta", pregunta)
        intent.putExtra("cont", cont)



        //al pulsar el boton me lleva a las respuestas
        binding.botonComprobar.setOnClickListener {

            //inicio el intent
            startActivity(intent)

        }












    }
}