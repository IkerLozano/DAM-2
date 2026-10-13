import 'package:flutter/material.dart';

void main() {
  runApp(App());
}

class App extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      debugShowCheckedModeBanner: false, //para quitar lo de la derecha
      theme: ThemeData.light(), //pone la pantalla en modo oscuro (light/dark)
      home: Scaffold(
        body: Center(
          child: Text("Hola mundo"),
        ),
      ),
    );
  }
}



