
import 'package:flutter/material.dart';

void main() {
  
  runApp(MiApp());
}

class MiApp extends StatelessWidget {
  const MiApp({super.key});

  @override
  Widget build(BuildContext context) {
   
    return MaterialApp(
      debugShowCheckedModeBanner: false, //para quitar lo de la derecha
      theme: ThemeData.light(), //pone la pantalla en modo oscuro
      home: Scaffold(
        body: Center(
          child: Text("Hola a DAM2")),
      ),
    );
  }


  
}