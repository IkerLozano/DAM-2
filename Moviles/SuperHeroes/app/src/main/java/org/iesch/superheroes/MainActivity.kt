package org.iesch.superheroes

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.health.connect.datatypes.units.Power
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityMainBinding
import org.iesch.superheroes.model.SuperHeroe
import java.io.File

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    // 1 - Creamos una variable que va a manejar el resultado de haber hecho la foto
    private lateinit var  heroImage: ImageView
    private var heroBitmap: Bitmap? = null
    // 1 - Hay que cambiar el TakepicturesPreview por takepictures
    private var picturePath = ""
    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture() ){
        // 1 - Ahora en lugar de un bitmap nos va a devolver un booleano, si la foto es exitosa o no
        success ->
            if ( success && picturePath.isNotEmpty() ){
                // cualquier imagen del directorio la podemos convertir a bitmap
                heroBitmap = BitmapFactory.decodeFile( picturePath )
                // Mostramos la imagen en el cuadradito
                heroImage.setImageBitmap( heroBitmap )
            }

    }


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

        // 2
        heroImage = binding.heroImage
        binding.heroImage.setOnClickListener {
            abrirCamara()
        }


        binding.btnGuardar.setOnClickListener {
            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.alterEgoEdit.text.toString()
            val bio = binding.alterEgoEdit.text.toString()
            val power = binding.power.rating
            val superHeroe = SuperHeroe(superHeroName,alterEgo,bio,power)

            irADetailActivity(superHeroe)
        }




    }

    fun abrirCamara() {
        // 2 - Aqui debemos crear un path temporal para guardar esa imagen
        val imageFile = crearImagenFile()

        // Ahora ya tenemos el File, pero lo que necesitamos es el uri
        // Sera a traves del FileProvider
        // FileProvider lo que hace es compartir el file con otras aplicaciones de forma segura
        val uri = FileProvider.getUriForFile( this, "${applicationContext.packageName}.provider", imageFile)
        getContent.launch(uri)
    }

    //3 - Esta funcion crea un File y de ese File recuperaremos la uri
    private fun crearImagenFile() : File {
        val fileName = "superhero_image"
        // Esto será el directorio donde vamos a almacenar la image.. Por defecto es DIRECTORY_PICTURES
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        // Creamos nuestro file, aqui nos pide el nombre, el formato, y el directorio
        val imageFile = File.createTempFile(fileName, ".jpg", fileDirectory)
        // Ahora ya podemos guardar la ruta (path) en la variable global
        picturePath = imageFile.absolutePath
        return imageFile
    }

    fun irADetailActivity(superHeroe: SuperHeroe) {
        // Creamos el objeto Intent
        val intent = Intent(this, DetailActivity::class.java)
        // Añadimos todos los campos con el metodo putExtra
        //intent.putExtra("superHeroName", superHeroName)
        //intent.putExtra("alterEgo", alterEgo)
        //intent.putExtra("bio", bio)
        //intent.putExtra("power",power)
        intent.putExtra( "superHero", superHeroe )
        // Añado el Objeto Bitmap al intent
        intent.putExtra("path_heroe", picturePath )
        // De esta manera, todos estos datos se enviarán al DetailActivity
        // Iniciamos la nueva actividad
        startActivity(intent)
    }


}