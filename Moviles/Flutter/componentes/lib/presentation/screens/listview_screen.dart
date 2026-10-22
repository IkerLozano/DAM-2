import 'package:flutter/material.dart';


class ListviewScreen extends StatelessWidget {

  final games = ["Sonic", "Rocket Night Adventures", "Cool Spot", "Micromachines", "SkibidyRemon"];
   ListviewScreen({super.key});


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Listview Tipo 1'),),
      body: ListView(
       children: [

          ...games.map( (juego) => ListTile(

              leading: Icon(Icons.access_time_sharp),
              title: Text('Hola mundo'),
              subtitle: Text('Juegos OGs'),
              onTap: (){

              },
              trailing: Icon(Icons.arrow_back),
          )
        ),
        Divider() //linea divisora
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


