import 'package:flutter/material.dart';

class ThemePrividers extends ChangeNotifier {

  //iniciamos el provider
  ThemeMode _themeMode = ThemeMode.light; //valor por defecto del sistema

  ThemeMode get themeMode => _themeMode;

  void cambiarTema(){

    _themeMode = _themeMode == ThemeMode.light ? ThemeMode.dark : ThemeMode.light;

    notifyListeners(); //para que los cambios se avisen
  }

}
