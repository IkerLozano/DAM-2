import 'package:flutter/material.dart';
import 'package:practica_evaluable/models/menu_options.dart';

class Pagina4 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {


    final listaPaginas = <MenuOptions>[
      MenuOptions(ruta: "Pagina3", icono: Icons.list, nombre: "Pagina 3"),
      MenuOptions(ruta: "Pagina5", icono: Icons.list, nombre: "Pagina 5"),
    ];

    return Scaffold(
      //barra de arriba
      appBar: AppBar(
        title: const Text("Pagina 4"),
        backgroundColor: Colors.orangeAccent,
        elevation: 2,
        centerTitle: true,
      ),


      //cuerpo de la app
      body: ListView.separated(

        itemBuilder: (context, i) => ListTile(


          //elementos de cada fila
          leading: Icon(listaPaginas[i].icono),
          title: Text(listaPaginas[i].nombre),
          onTap: () {
            Navigator.pushNamed(context, listaPaginas[i].ruta);
          },

          trailing: const Icon(Icons.arrow_forward_ios), //icono de la derecha
        ),


        separatorBuilder: (_, __) =>const Divider(), //separadores entre las filas
        itemCount:listaPaginas.length, //indica cuántas filas debe tener la lista
      )
    );
  }
}
