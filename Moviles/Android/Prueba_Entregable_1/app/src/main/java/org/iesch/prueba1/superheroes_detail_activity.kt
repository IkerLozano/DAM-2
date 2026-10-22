package org.iesch.prueba1

import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.prueba1.databinding.ActivitySuperheroesDetailBinding
import org.iesch.prueba1.model.Superheroe

class superheroes_detail_activity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroesDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySuperheroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        // Recivo los datos del objeto
        // Dependiendo la versión del SDK uso una cosa u otra
        val superheroe = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            // Para versiones SDK 33 o suepriores

            intent.getParcelableExtra("superHeroe", Superheroe::class.java)
        } else {
            // Para versiones anteriores que la 33
            intent.getParcelableExtra<Superheroe>("superHeroe")
        }



        binding = ActivitySuperheroesDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val bundle = intent.extras!!
        val bitmapDirection = bundle.getString("path_heroe")
        val bitmap = BitmapFactory.decodeFile(bitmapDirection)



        // Ahora hay que rellenar los campos
        binding.heroNameTv.text = superheroe?.nombre ?: "No hay nombre"
        binding.alterEgoResult.text = superheroe?.alterEgo ?: "No hay alterego"
        binding.Bioesult.text = superheroe?.bio ?: "No hay bio"

        //Pongo la foto
        binding.imagenHeroeGrande.setImageBitmap(bitmap)

        binding.ratingBar2.rating = superheroe?.poder ?: 0f // la f es para especificar float
    }
}