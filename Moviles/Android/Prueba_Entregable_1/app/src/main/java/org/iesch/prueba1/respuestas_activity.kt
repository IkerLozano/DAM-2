package org.iesch.prueba1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.prueba1.databinding.ActivityRespuestasBinding
import org.iesch.prueba1.model.Cuestionario

class respuestas_activity : AppCompatActivity() {

    private lateinit var binding: ActivityRespuestasBinding

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

        // Datos que llegan de preguntas_activity
        val indice = intent.getIntExtra("indice", 0)
        val acierto = intent.getBooleanExtra("acierto", false)
        val esUltima = indice == Cuestionario.preguntas.size - 1

        // Imagen y texto según se haya acertado o fallado
        if (acierto) {
            binding.imgaenBien.setImageResource(R.drawable.acierto)
            binding.textoRespuesta.setText(R.string.respuesta_correcta)
        } else {
            binding.imgaenBien.setImageResource(R.drawable.fallo)
            binding.textoRespuesta.setText(R.string.respuesta_fallo)
        }

        // Si es la última pregunta: mensaje de fin y botón para volver a empezar
        if (esUltima) {
            binding.textoRespuesta.append("\n\n" + getString(R.string.cuestionario_finalizado))
            binding.botonSiguiente.setText(R.string.Volver_a_empezar)
        }

        binding.botonSiguiente.setOnClickListener {
            val intent = Intent(this, preguntas_activity::class.java)
            if (!esUltima) {
                intent.putExtra("indice", indice + 1)
            }
            // Si es la última, no se manda nada y el cuestionario empieza de nuevo
            startActivity(intent)
            finish()
        }
    }
}