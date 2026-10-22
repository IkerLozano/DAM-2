import 'package:flutter/material.dart';

// CORREGIDO: Añadido el '2' al nombre de la clase para que coincida con el constructor
class Listview2Screen extends StatelessWidget {

  final games = ["Sonic", "Rocket Night Adventures", "Cool Spot", "Micromachines", "SkibidyRemon"];
   Listview2Screen({super.key});


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Listview Tipo 2'),),
      body: ListView.separated(
        itemBuilder: (context, index) => ListTile(

              leading: Icon(Icons.gamepad),
              title: Text(games[index]),
              subtitle: Text('Juegos OGs'),
              onTap: (){
              
              },
              trailing: Icon(Icons.arrow_back),
          ),

        separatorBuilder: (_, __) => const Divider(),
        itemCount: games.length,
      )
   );
  }
}
