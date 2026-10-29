import 'package:flutter/material.dart';

// CORREGIDO: Añadido el '2' al nombre de la clase para que coincida con el constructor
class Listview2Screen extends StatelessWidget {

  Listview2Screen({super.key});

  //lista de juegos y subtitulos, visible para todo el documento
  final games = ["Sonic", "Rocket Night Adventures", "Cool Spot", "Micromachines", "SkibidyRemon"];
  final subtitulos = ["Plataformas", "Aventura", "Plataformas", "Carreras", "Memes"];

  

  //otra forma de crear una lista, en "ListviewScreen" esta la forma 1
  @override
  Widget build(BuildContext context) {
    return Scaffold(

      appBar: AppBar(title: Text('Listview Tipo 2'),),
      body: ListView.separated(
        //body --> indica el contenido de la pantalla 
        //separated --> indica que la lista tendrá un separador entre cada elemento
        
        itemBuilder: (context, i) => ListTile( 
          //itemBuilder construye cada fila de la lista.
          //ListTile: crea una fila con información e iconos.

              leading: Icon(Icons.gamepad), //icno de la izquierda 
              title: Text(games[i]), //el titulo con el juego
              subtitle: Text(subtitulos[i]), //subtitulo
              onTap: (){ //Define qué ocurre al pulsar la fila, en este caso nada
              
              },
              trailing: Icon(Icons.arrow_back), //icono de la derecha
          ),

        separatorBuilder: (_, __) => const Divider(),
        //separatorBuilder construye los separadores entre las filas.
        //_ y __: son parámetros que no necesitamos usar
        //=> const Divider(), devuleve un separador, aqui podemos colocae una linea o cualquier cosa

        itemCount: games.length, //indica cuántas filas debe tener la lista
      )
   );
  }
}
