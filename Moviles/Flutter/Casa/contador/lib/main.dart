import 'package:contador/presentation/screens/contador_screen.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MiApp()); //aranca la palicacion
}

//configuraciones generales de la app (temas, cual es la pantalla principal...)
class MiApp extends StatelessWidget {
  const MiApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner:
          false, //quita la etiqueta roja “DEBUG” de la esquina
      theme: ThemeData(
        //aqui dentro decimos como queremos que sea el tema visual general de la app.
        useMaterial3: true, //Es el sistema de diseño de Google que define el aspecto
        colorSchemeSeed: Colors.blue, //color de la app
        brightness: Brightness.dark //modo oscuro
      ),

      home: ContadorScreen(), //esto indica cual es la pantalla inicial
    );
  }
}
