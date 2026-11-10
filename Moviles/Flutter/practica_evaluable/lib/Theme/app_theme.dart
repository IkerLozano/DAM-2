import 'package:flutter/material.dart';

class AppTheme {


  //Color primario
  static const Color primary = Colors.pink;

  //Color segundario
  static const Color segundary = Colors.yellow;


  //Tema personalizado para los iconos
  static final ThemeData lightTheme = ThemeData.light().copyWith(
    
    useMaterial3: false,

    //color de los iconos dentro de ListTile (leading y trailing)
    listTileTheme: ListTileThemeData(iconColor: primary),
  );
  



  


  
}