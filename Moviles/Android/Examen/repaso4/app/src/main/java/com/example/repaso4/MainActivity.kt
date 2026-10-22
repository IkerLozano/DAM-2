package com.example.repaso4

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso4.databinding.ActivityDetailBinding
import com.example.repaso4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //empieza el codigo


        //al darle al boton
        binding.botonEntrar.setOnClickListener {

            //recojo los datos
            var usuario = binding.editTextUser.text.toString()
            var contrasena = binding.editTextPasswd.text.toString()


            //con if compurblo si hay informacion en los datos
            if (usuario.isEmpty() && contrasena.isEmpty()){

                Toast.makeText(this, "El usuario y la contraseña estan vacios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else if (usuario.isEmpty()){

                Toast.makeText(this, "El usuario esta vacio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else if (contrasena.isEmpty()){

                Toast.makeText(this, "La contraseña esta vacia", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }


            //indico a activity voy
            var intent = Intent(this, DetailActivity::class.java)


            //meto los datos en el intent
            intent.putExtra("usuario", usuario)
            intent.putExtra("contrasena", contrasena)


            //incio el intent
            startActivity(intent)

        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("CLICO_VIDA", "Metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CLICO_VIDA", "Metodo onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CLICO_VIDA", "Metodo onPuase")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CLICO_VIDA", "Metodo onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CLICO_VIDA", "Metodo onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CLICO_VIDA", "Metodo onDestroy")
    }



}