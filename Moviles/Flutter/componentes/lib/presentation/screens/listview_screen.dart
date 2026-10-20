import 'package:flutter/material.dart';


class ListviewScreen extends StatelessWidget {
  const ListviewScreen({super.key});


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Listview Tipo 1'),),
      body: ListView(
       children: [
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
       ],
      )
   );
  }
}


