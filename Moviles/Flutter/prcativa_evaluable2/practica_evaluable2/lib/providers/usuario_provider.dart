import 'package:flutter/material.dart';

class UsuarioProvider extends ChangeNotifier {

  String usuario = "";
  String password = "";

  void guardarDatos(String nuevoUsuario, String nuevaPassword) {
    usuario = nuevoUsuario;
    password = nuevaPassword;

    notifyListeners();
  }
}