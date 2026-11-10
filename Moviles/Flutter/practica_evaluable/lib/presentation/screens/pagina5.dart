import 'package:flutter/material.dart';
import 'package:practica_evaluable/models/menu_options.dart';

class Pagina5 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    final listaPaginas = <MenuOptions>[
      MenuOptions(ruta: "Pagina1", icono: Icons.list, nombre: "Pagina 1"),
      MenuOptions(ruta: "Pagina2", icono: Icons.list, nombre: "Pagina 2"),
      MenuOptions(ruta: "Pagina4", icono: Icons.list, nombre: "Pagina 4"),
    ];

    return Scaffold(
      //barra de arriba
      appBar: AppBar(
        title: const Text("Pagina 5"),
        backgroundColor: Colors.indigo,
        elevation: 2,
        centerTitle: true,
      ),

      //cuerpo de la app
      body: Column(
        children: [
          ListView.separated(
            shrinkWrap: true, //hace que el ListView ocupe únicamente el espacio que necesitan
            itemBuilder: (context, i) => ListTile(
              //elementos de cada fila
              leading: Icon(listaPaginas[i].icono),
              title: Text(listaPaginas[i].nombre),
              onTap: () {
                Navigator.pushNamed(context, listaPaginas[i].ruta);
              },
          
              trailing: const Icon(Icons.arrow_forward_ios), //icono de la derecha
            ),
          
            separatorBuilder: (_, __) => const Divider(), //separadores entre las filas
            itemCount:listaPaginas.length, //indica cuántas filas debe tener la lista
            
          ),

          //boton para borrar la pila
          const Boton()

        ],
      ),

      
     
    );
  }
}

class Boton extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return ElevatedButton.icon(
      style: ElevatedButton.styleFrom(
        backgroundColor: Colors.indigo,
      ),
      onPressed: () {
         Navigator.pushNamedAndRemoveUntil(
          context,
          "/",
          (route) => false,
        );
      },
      label: Text("Eliminar pila y volver a Pantalla 1"),
      icon: Icon(Icons.add_alert_outlined),
      
    );
  }
}
