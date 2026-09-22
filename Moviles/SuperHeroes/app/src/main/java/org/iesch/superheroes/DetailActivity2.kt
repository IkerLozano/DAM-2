package org.iesch.superheroes

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //Ultimo paso: recibinos los datos del MiaNActivity
        val datosRecibidos = intent.extras!!

        val superHeroName = datosRecibidos.getString("superHeroName") ?: "No hay nombre" //esto  no va pq no es un valor nulo, es un valor vacio
        val alterEgo = datosRecibidos.getString("alterEgo") ?: "No hay alter ego"
        val bio = datosRecibidos.getString("bio") ?: "No hay biografia"
        val power = datosRecibidos.getFloat("power")

        //rellenamos los campos con los valores recibidos
        findViewById<TextView>(R.id.heroName).text = superHeroName
        findViewById<TextView>(R.id.alterEgo_result).text = alterEgo
        findViewById<TextView>(R.id.Biografia).text = bio
        findViewById<RatingBar>(R.id.ratingResult).rating = power
    }
}