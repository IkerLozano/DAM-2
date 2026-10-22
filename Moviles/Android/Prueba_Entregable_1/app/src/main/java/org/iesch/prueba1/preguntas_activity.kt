package org.iesch.prueba1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.prueba1.databinding.ActivityPreguntasBinding
import org.iesch.prueba1.model.Cuestionario

class preguntas_activity : AppCompatActivity() {

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

        // Pregunta actual (si no llega nada, empieza en la primera)
        val indice = intent.getIntExtra("indice", 0)
        val total = Cuestionario.preguntas.size
        val pregunta = Cuestionario.preguntas[indice]

        // Pintar la pregunta y las opciones
        binding.pregunta.setText(pregunta.texto)

        if (pregunta.opcion1Res != 0) {
            binding.opcion1.setText(pregunta.opcion1Res)
        } else {
            binding.opcion1.text = pregunta.opcion1Texto
        }

        if (pregunta.opcion2Res != 0) {
            binding.opcion2.setText(pregunta.opcion2Res)
        } else {
            binding.opcion2.text = pregunta.opcion2Texto
        }

        binding.numPregunta.text = "${indice + 1} / $total"
        binding.progressBar.max = total
        binding.progressBar.progress = indice + 1

        // Al pulsar Enviar
        binding.botonEnviar.setOnClickListener {
            val elegida = when (binding.radioGroup.checkedRadioButtonId) {
                R.id.opcion1 -> 1
                R.id.opcion2 -> 2
                else -> 0
            }

            // Si no hay nada marcado: Toast y no se avanza
            if (elegida == 0) {
                Toast.makeText(this, getString(R.string.sin_seleccion), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, respuestas_activity::class.java)
            intent.putExtra("indice", indice)
            intent.putExtra("acierto", elegida == pregunta.correcta)
            startActivity(intent)
            finish()
        }
    }
}