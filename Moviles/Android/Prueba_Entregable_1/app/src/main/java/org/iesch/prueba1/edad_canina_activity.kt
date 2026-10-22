package org.iesch.prueba1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class edad_canina_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edad_canina)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //Aqui la pantalla esta creada

        //1- Tomamos el control de todos los elementos de la parte de UI

        val resultText = findViewById<TextView>(R.id.textoRespuesta)
        val calculateButon = findViewById<Button>(R.id.botonCalcular)
        val ageEdit =  findViewById<EditText>(R.id.Respuesta)

        //2- los botones tienen la propiedad setOnClickListener al pulsarlo
        calculateButon.setOnClickListener {
            //aqui metemos el codigo de lo que queremos hacer cuando pulsemos el boton
            val  edadString = ageEdit.text.toString()

            if(edadString.isEmpty()){
                //3- mostramos un mensaje de tipo Toast
                Toast.makeText(this, "El campo esta vacio", Toast.LENGTH_LONG).show()
            }else{

                //necesitamos pasar el valor a entero
                val edadInt = edadString.toInt()
                val dogAge = edadInt*7

                //println(dogAge)
                resultText.text = getString(R.string.mensajePersonalizado, dogAge)
            }


        }
    }
}