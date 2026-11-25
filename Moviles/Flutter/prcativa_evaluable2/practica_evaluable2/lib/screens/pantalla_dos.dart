import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:practica_evaluable2/providers/usuario_provider.dart';

class PaginaDos extends StatelessWidget {
  const PaginaDos({super.key});

  @override
  Widget build(BuildContext context) {
    final datos = context.watch<UsuarioProvider>();

    return Scaffold(
      appBar: AppBar(
        title: Text("Datos del usuario"),
        centerTitle: true,
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Center(
            child: Text(
              "Usuario: ${datos.usuario}",
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
          SizedBox(height: 20),
          Text(
            "Contraseña: ${datos.password}",
            style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
            ),
          ),
        ],
      ),
    );
  }
}