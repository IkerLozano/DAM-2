import 'package:componentes/models/menu_options.dart';
import 'package:flutter/material.dart';



class Practica8 extends StatefulWidget {
  const Practica8({super.key});

  @override
  State<Practica8> createState() => _Practica8State();
}

class _Practica8State extends State<Practica8> {

  //para saber si el cuadrado esta en su estado inicial o no
  bool cambiado = false;

  @override
  Widget build(BuildContext context) {
    final listaPaginas = <MenuOptions>[
      MenuOptions(ruta: "Practica8", icono: Icons.list, nombre: "Practica 8"),
    ];




    return Scaffold(


      //barra de arriba
      appBar: AppBar(title: const Text("Practica 8")),


      //cuerpo de la aplicación
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,

          children: [
            AnimatedContainer( //widget (explicacion abajo)

              duration: const Duration(seconds: 1), //duracion de la animacion (1 seg dura)
              width: cambiado ? 250 : 100, //anchura, le digo que elija entre esos dis valores segun si la condicion es true/false
              height: cambiado ? 150 : 100, //altura
              color: cambiado ? Colors.pink : Colors.blue, //color de fondo
            ),


            ElevatedButton(
              onPressed: () {
                setState(() { //con esto indico que el estado ha cambiado y que debe actualizar la interfaz
                  cambiado = !cambiado;
                });
              },
              child: const Text("Cambiar"),
            ),
          ],
        ),
      ),
    );
  }
}


//AnimatedContainer
//Es un contenedor que permite realizar animaciones 
//automáticamente cuando cambian algunas de sus propiedades.