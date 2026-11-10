import 'package:flutter/material.dart';

class SnackBarScreen extends StatelessWidget {
  // Corregido el nombre del constructor
  const SnackBarScreen({super.key}); 

  void mostrarSnackBarPersonalizado(BuildContext context) {
    // Ahora sí limpiará los anteriores correctamente
    ScaffoldMessenger.of(context).clearSnackBars();

    final snackBar = SnackBar(
      content: const Text("Hola a DAM2"),
      duration: const Duration(seconds: 2),
      backgroundColor: Colors.deepOrange,
      action: SnackBarAction(//para cerrarlo
        label: 'OK',
        onPressed: () {},
      ),
    );

    // Muestra el mensaje actual
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("SnackBar"),
      ),

      body: Builder(
        builder: (context) {
          return const Center(
            child: Text("SnackBarScreen"),
          );
        },
      ),
      floatingActionButton: Builder(
        builder: (context) {
          return FloatingActionButton.extended(
            icon: const Icon(Icons.remove_red_eye_outlined),
            onPressed: () => mostrarSnackBarPersonalizado(context),
            label: const Text("Mostrar SnackBar"),
          );
        },
      ),
    );
  }
}
