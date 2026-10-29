import 'package:flutter/material.dart';


class CardTipo2 extends StatelessWidget {

  final String urlImagen;
  final String? texto; //? --> opcional
  

  const new({
    super.key,
    required this.urlImagen,
    this.texto
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      clipBehavior: Clip.antiAlias, //para que la imagen  no se salga de la tarjeta y redondea los bordes
      shape: RoundedRectangleBorder(borderRadius: BorderRadiusGeometry.circular(15)),//redondear mas
      child: Column(
        children: [
          FadeInImage(
            fit: BoxFit.cover, //===========explicar=========
            image: NetworkImage(urlImagen),
            placeholder: AssetImage("assets/jar-loading.gif"),//meter el nombre de la carpeta y el archivo, es como una transicion
            //le ponemos el mismo tamaño que e sgif para q no pege el golpe
            width: double.infinity, //ocupa todo lo que pueda
            height: 230,
            fadeInDuration: Duration(milliseconds: 1200),//la transicion desde que se acaba el git hasta q sale la foto
          ),

          if (texto != null)
            Container(
              padding: EdgeInsets.only(right: 20, top: 10, bottom: 10),
              child: Text(texto!)
            )
        ],
      ),
    );
  }
}