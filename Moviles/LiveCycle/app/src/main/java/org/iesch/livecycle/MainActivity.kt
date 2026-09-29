package org.iesch.livecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
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

        //codigo desde aqui


        val boton = findViewById<Button>(R.id.btnMainActivity)
        boton.setOnClickListener {

            val intent = Intent(this, OtraActivity::class.java)
            startActivity(intent)
            //finish()

        }


        Log.i("CICLO_VIDA", "Entramos en el metodo onCreate()")

    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLO_VIDA", "Entramos en el metodo onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLO_VIDA", "Entramos en el metodo onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLO_VIDA", "Entramos en el metodo onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLO_VIDA", "Entramos en el metodo onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CICLO_VIDA", "Entramos en el metodo onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLO_VIDA", "Entramos en el metodo onDestroy()")
    }

}