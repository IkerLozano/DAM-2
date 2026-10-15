
import 'package:contador/presentation/screens/contador_screen.dart';
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
      theme: ThemeData.dark(
        useMaterial3: true
      ), //pone la pantalla en modo oscuro
      
      home: ContadorScreen()
    );
  }


  
}