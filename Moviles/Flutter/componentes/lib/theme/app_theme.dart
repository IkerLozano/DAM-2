//para los temas generales
import 'package:flutter/material.dart';

class AppTheme {
  //Color primario
  static const Color primary = Colors.pink;

  //Color segundario
  static const Color segundary = Colors.yellow;

  //Tema light
  static final ThemeData lightTheme = ThemeData.dark().copyWith(
    //color primario
    primaryColor: primary,

    useMaterial3: false,
    //AppBar
    appBarTheme: AppBarTheme(backgroundColor: primary, elevation: 0),
  );
  



  //Tema halloween
  static final ThemeData halloweenTheme = ThemeData.dark().copyWith(

    useMaterial3: false,
    appBarTheme: AppBarTheme(
      backgroundColor: const Color.fromARGB(255, 255, 112, 17),
      elevation: 0,
    ),
    iconTheme: IconThemeData(color: const Color.fromARGB(255, 255, 139, 7)),

    
  );
  
}
