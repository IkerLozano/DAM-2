package com.example.repaso4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso4.databinding.ActivityDetailBinding
import com.example.repaso4.databinding.ActivityUsuarioMainBinding

class UsuarioMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsuarioMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUsuarioMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //empieza el codigo


        //al darle al boton
        binding.botonCalcular.setOnClickListener {


            //recojo los datos
            var nombre = binding.editTextNombre.text.toString()
            var noches = binding.editTextNoches.text.toString()
            var rating = binding.rating.rating


            //con if compurblo si hay informacion en los datos
            if (nombre.isEmpty() && noches.isEmpty()){

                Toast.makeText(this, "El nombre y la noches estan vacios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else if (nombre.isEmpty()){

                Toast.makeText(this, "El nombre esta vacio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else if (noches.isEmpty()){

                Toast.makeText(this, "Las noches estan vacias", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

            //calculo el precio del hotel
                //3 a 6	--> 10 %
                //7 o más --> 20 %

            var precioXnoche = 0f
            var precioSD = 0f
            var precioT = 0f


                //calculo el precio por noche segun las estrellas
            if ((rating <= 1f && rating < 2f)){
                precioXnoche = 40f
                precioSD = precioXnoche * noches.toInt()
            }else if(rating >= 2f && rating < 3f){
                precioXnoche = 55f
                precioSD = precioXnoche * noches.toInt()
            }else if(rating >= 3f && rating < 4f) {
                precioXnoche = 75f
                precioSD = precioXnoche * noches.toInt()
            }else if(rating == 4f && rating < 5f) {
                precioXnoche = 110f
                precioSD = precioXnoche * noches.toInt()
            }else if(rating == 5f) {
                precioXnoche = 160f
                precioSD = precioXnoche * noches.toInt()
            }

                //calculo el precioT segun las noches
            if (noches.toInt() in 3..6){

                precioT = precioSD*(90f/100)

            }else if (noches.toInt() >= 7){

                precioT = precioSD*(80f/100f)
            }


            //indico a que activity voy
            var intent = Intent(this, UsurioDetailActivity::class.java)


            //meto los datos en el intent
            intent.putExtra("nombre", nombre)
            intent.putExtra("noches", noches)
            intent.putExtra("rating", rating)
            intent.putExtra("precioT", precioT)

            //inicio el intent
            startActivity(intent)


        }



    }
}