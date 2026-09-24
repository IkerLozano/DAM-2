package org.iesch.superheroes

import android.app.Activity
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
import androidx.activity.result.ActivityResult
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

    // 1 - Creamos la variable lateinit porque la vamos a inicializar luego
    private lateinit var binding: ActivityMainBinding

    //1-Creamos una variable que va a manejar el resultado de a ver escho la foto
    private lateinit var heroImage: ImageView
    private var heroBitMap: Bitmap? = null

    //1- hayque cambiar el metodoTakePicturesPreview por Takepictures
    private var picturePath = ""
    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()){
        //Ahora en lugar de un BipMap nos va a devolver un booleano, si la foto es exitosa o no
        success ->
            if ( success && picturePath.isEmpty() ){
                //cualquier imagen del directorio la podemos convertir a bitmap
                heroBitMap = BitmapFactory.decodeFile(picturePath)

                //mostramos l aimagen en el cuadradito
                heroImage.setImageBitmap(heroBitMap)
            }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 2 - Inicializamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // 3 - Usamos el binding para inflar la vista
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2-
        heroImage = binding.heroImage
        binding.heroImage.setOnClickListener {
            abrirCamara()
        }

        //esto pasa alpulsar el boton
        // A partir de aqui introduzo el codigo necesario
        // val botonGuardar = findViewById<Button>(R.id.btn_guardar)
        binding.btnGuardar.setOnClickListener {
            // Obtenemos los valores al momento de hacer click
            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.alterEgoEdit.text.toString()
            val bio = binding.alterEgoEdit.text.toString()
            val power = binding.power.rating
            // 2 - Me creo el objeto SuperHeroe
            val superHeroe = SuperHeroe(superHeroName,alterEgo,bio,power)
            // Qué quiero hacer cuando pulso el Boton Guardar
            irADetailActivity(superHeroe)
        }




    }

    fun irADetailActivity(superHeroe: SuperHeroe) {
        // Creamos el objeto Intent
        var intent = Intent(this, DetailActivity::class.java)
        // Añadimos todos los campos con el metodo putExtra
        //intent.putExtra("superHeroName", superHeroName)
        //intent.putExtra("alterEgo", alterEgo)
        //intent.putExtra("bio", bio)
        //intent.putExtra("power",power)
        intent.putExtra( "superHero", superHeroe )
        //añado el objeto bitmapal intent
        intent.putExtra("path_Heroe", picturePath) //para que la foto se pase tamb a la segunda pantalla
        // De esta manera, todos estos datos se enviarán al DetailActivity
        // Iniciamos la nueva actividad
        startActivity(intent)
    }

    fun abrirCamara(){
        //3- aqui devemos quedar un path temporal para guardar esa imagen

        var imagenFile = crerImganeGile()

        //ahora ya tenemos el File, pero lo que necesitamos en el url
        //sera a traves del fielProvider
        //FilePorvider lo que hace es compartir el file con otras apps de forma segura
        val uri = FileProvider.getUriForFile(this, "${applicationContext.packageName}.provider", imagenFile)
        getContent.launch(uri)
    }

    //4- esta funcion crea un file y de ese File recuperamos la url
    private fun crerImganeGile() : File {
        var fileName = "superhero_image"

        //esto sera el directorio dnd vamos a almacenar la imagen, Por defecto es directory_pictures
        var fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        //creamos nuestro file, aqui nos pide el nombre, en formato y en directorio
        var imageFile = File.createTempFile(fileName, ".jpg", fileDirectory)

        //ahora podemos guardar la ruta (path) en la variable global
        picturePath = imageFile.absolutePath
        return imageFile
    }


}