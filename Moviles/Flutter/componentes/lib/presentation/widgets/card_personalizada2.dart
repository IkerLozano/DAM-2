import '../screens.dart';


class CardTipo2 extends StatelessWidget {

  //variables
  final String urlImagen;
  final String? texto; //? --> opcional
  

  //cuando la creemos le tenemos que poner una foto obligatoria y un texto opcional
  const new({
    super.key,
    required this.urlImagen,
    this.texto
  });


  @override
  Widget build(BuildContext context) {
    return Card(
      clipBehavior: Clip.antiAlias, //se recorta el contenido que sobresale de la tarjeta siguiendo los bordes redondeados y suaviza los bordes
      shape: RoundedRectangleBorder(borderRadius: BorderRadiusGeometry.circular(15)),//lo redondea un poco mas
      //shape --> nos permite modificar la forma de la tarjeta
      child: Column(
        children: [
          FadeInImage( //mostrar una imagen provisional mientras se carga la imagen definitiva
            fit: BoxFit.cover, //explicado en los apuntes
            image: NetworkImage(urlImagen), //cargar imágenes desde Internet.
            placeholder: AssetImage("assets/jar-loading.gif"),//meter el nombre de la carpeta y el archivo
            //AssetImage --> carga una imagen que tenemos guardada en nuestro proyecto.
            
           
            width: double.infinity, //ocupa todo el ancho que
            height: 230,  //le ponemos el mismo tamaño que e gif para q no pege "el golpe"
            fadeInDuration: Duration(milliseconds: 1200),//la transicion desde que se acaba el gif hasta q sale la foto
          ),

          //si la imagen tiene el texto añado un padding para que se va mjr, si no hay texto  no pongo nada
          if (texto != null)
            Container(
              padding: EdgeInsets.only(right: 20, top: 10, bottom: 10),
              child: Text(texto!) //"!" indica a Dart que estamos seguros el que el texto no es null
            )
        ],
      ),
    );
  }
}