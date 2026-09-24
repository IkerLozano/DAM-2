package org.iesch.superheroes

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityDetailBinding
import org.iesch.superheroes.model.SuperHeroe


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1.
        val superHeroe = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU){
            //Para versiones SDK 33 o superiores
            intent.getParcelableExtra("superHero", SuperHeroe::class.java)
        }else{
            //para versiones anteriores a la 33
            intent.getParcelableExtra<SuperHeroe>("superHero")
        }

        // Ultimo paso: Recibimos los datos del Main Activity
        val bundle = intent.extras!!
        //var bitmap = bundle.getParcelable<Bitmap>("Foto_Heroe")
        val bitMapDirectory = bundle.getString("path_heroe")
        val bitmap = BitmapFactory.decodeFile(bitMapDirectory)
        //val superHeroName = bundle.getString("superHeroName") ?: "No hay nombre"
        //val alterEgo = bundle.getString("alterEgo") ?: "No hay AlterEgo"
        //Val bio = bundle.getString("bio") ?: "No hay bio"
        //val power = bundle.getFloat("power")

        // Rellenamos los campos conlos valores recibidos
        binding.heroNameTv.text = superHeroe?.nombre ?: "No hay nombre" //? por si lleva nulo
        binding.alterEgoResult.text = superHeroe?.alterEgo ?: "No hay alter Ego"
        binding.bioResult.text = superHeroe?.bio ?: "No hay bio"
        binding.ratingResult.rating = superHeroe?.power ?: 0f //f pq es float

        //asigno la imagen a la imagenView
        binding.imagenHeroe.setImageBitmap(bitmap)

    }
}














