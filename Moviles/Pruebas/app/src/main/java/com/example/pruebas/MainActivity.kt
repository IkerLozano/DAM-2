package com.example.pruebas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Aqui empieza la parte funcional

        //1. Cogemos tdos los elemtos que necesitemos
        val textInfo = findViewById<EditText>(R.id.edad) //esto es dnd se mete la edad
        val boton = findViewById<Button>(R.id.boton) //boton de calcular
        val meterEdad = findViewById<TextView>(R.id.textoResp) //texto que se muetsra con la edad calculada


        //2. los botones tienen la propiedad setOnClickListener al pulsarlo
        boton.setOnClickListener {  //odo lo de aqui dentro se ejecutara cuando se pulse el boton

            val edadString = textInfo.text.toString() //con el .text() cogemos el texto del TextView, y lo pasamos a Strinf para abajo comprobar si esta vacio ese TextView

            //3. Mostramos un mensaje si al pulsar el EditText esta vacio
            if (edadString.isEmpty()){

                Toast.makeText(this, "Esta vacio", Toast.LENGTH_LONG).show()
                //toast es un mensaje flotante
            }else{

                //volvemos a psar la edad a numero para hacer el calculo
                val edadInt = edadString.toInt()
                val edadFinal = edadInt*7

                //mostramos el resultado
                meterEdad.text = getString(R.string.mensajePersonalizado, edadFinal)
            }



        }
    }
}