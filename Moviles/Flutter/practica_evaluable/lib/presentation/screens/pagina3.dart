import 'package:flutter/material.dart';
import 'package:practica_evaluable/models/menu_options.dart';

class Pagina3 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {

    final listaPaginas = <MenuOptions>[
      MenuOptions(ruta: "Pagina1", icono: Icons.list, nombre: "Pagina 1"),
      MenuOptions(ruta: "Pagina2", icono: Icons.list, nombre: "Pagina 2"),
    ];

    return Scaffold(
      //barra de arriba
      appBar: AppBar(
        title: const Text("Pagina 3"),
        backgroundColor: Colors.redAccent,
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
      ),
    );
  }
}
