import 'package:flutter/material.dart';


class ListviewScreen extends StatelessWidget {


  ListviewScreen({super.key});


  //lista de juegos, visible para todo el documento
  final games = ["Sonic", "Rocket Night Adventures", "Cool Spot", "Micromachines", "SkibidyRemon"];
  

  //otra forma de crear una lista, en "Listview2Screen" esta la forma 2
  @override
  Widget build(BuildContext context) {
    return Scaffold(  //Scaffold: proporciona la estructura básica de la pantalla.

      //barra superior
      appBar: AppBar(title: Text('Listview Tipo 1'),),
      body: ListView(   //ListView: crea una lista desplazable cuando sus elementos no caben en pantalla.

       children: [ //widgets de la lista

          //recorro la lista de juegos, cada juego lo devuelvo como un "ListTile"
          ...games.map( (juego) => ListTile(  //ListTile es un widget que crea una fila preparada para mostrar información, normalmente en una lista.

              leading: Icon(Icons.access_time_sharp), //icno de la izquierda 
              title: Text(juego), //cada fila muestra su nombre de juego
              subtitle: Text('Juegos OGs'), //texto secundario
              onTap: (){ //sirve para indicar qué ocurre cuando pulsas, ahora no hace nada pq cuando pulsamos en un juego no nos lleva a ningun sitio, es como el onPressed
                    
                    //ScaffoldMessenger.of(context).showSnackBar(
                    //SnackBar(content: Text('Has pulsado $juego')),
                    //);

              },
              trailing: Icon(Icons.arrow_back), //icono de la derecha
          )
        ),

        Divider() //linea divisora

        //se podian poner asi pero es de noobs
        /*
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
            subtitle: Text('jhb dfdyhs vs dervgfde sfvdsghfvdsgfdgs  vg vgh '),
            onTap: (){

            },
            trailing: Icon(Icons.arrow_back),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          )
          */
          
       ],
      )
   );
  }
}


