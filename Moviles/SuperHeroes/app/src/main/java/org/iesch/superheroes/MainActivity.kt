package org.iesch.superheroes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Telephony
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    //1. creamos la variable de tipo lateinit porque la vamos a inicializar luego
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //2. iniciamos en binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        //3. usamos el binding para inflar la vista
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Aprtir de aqui inrtoduzco el codigo necesario


        //1.
        binding.btnGuardar.setOnClickListener {

            //Obtnemos los valores de los campos al momento de hacer clik
            val superHeroName = binding.heroNameEdit.text.toString() //por si metenumeros o lo que sea alo pasamos a String
            val alterEgo = binding.alterEgoEdit.text.toString() //por si metenumeros o lo que sea alo pasamos a String
            val bio = binding.bioEdit.text.toString() //por si metenumeros o lo que sea alo pasamos a String
            val power = binding.power.rating //por si metenumeros o lo que sea alo pasamos a String


            //que quiero hacer cuando pulso el boton "Guardar"

            irADetailActivity(superHeroName, alterEgo, bio, power)



        }

    }

    fun irADetailActivity(superHeroName: String, alterEgo: String, bio: String, power: Float) {

        //creamos el objeto Intent
        val intent = Intent(this, DetailActivity2::class.java)
        //añadimos todos los campos con el metodo putExtra()
        intent.putExtra("superHeroName", superHeroName)
        intent.putExtra("alterEgo", alterEgo)
        intent.putExtra("bio", bio)
        intent.putExtra("power", power)
        //de esta manera todos estos datos se enviaran al DetailActivity
        //lo ejecuto
        startActivity(intent)

    }
}