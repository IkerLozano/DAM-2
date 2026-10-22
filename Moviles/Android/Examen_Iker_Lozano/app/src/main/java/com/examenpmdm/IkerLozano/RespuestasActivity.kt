package com.examenpmdm.IkerLozano

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.examenpmdm.IkerLozano.databinding.ActivityRespuestasBinding
import org.jetbrains.annotations.ApiStatus

class RespuestasActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRespuestasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRespuestasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //empeizo el codigo


        //recojo los datos
        var datos = intent.extras!! //recibo los datos


        //saco los satos
        var cont = intent.getIntExtra("cont", 0)

        if (cont == 0){
            cont++
        }else  if(cont == 1){
            cont++
        }else if(cont == 2){
            cont++
        }


        intent.putExtra("cont", cont)




        //pulso el boton para volver a las preguntas
        binding.botonVolver.setOnClickListener {

            var intent = Intent(this, PreguntasActivity::class.java)
            startActivity(intent)

        }
    }
}