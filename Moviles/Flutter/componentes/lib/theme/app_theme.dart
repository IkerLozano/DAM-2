//para los temas generales
import 'package:flutter/material.dart';


class AppTheme {

  //Color primario
  static const Color primary = Colors.pink;

  //Color segundario
  static const Color segundary = Colors.yellow;


  //Tema light
  static final ThemeData lightTheme = ThemeData.light().copyWith(
    
    primaryColor: primary, //color primario, cuando queramos usarlos poner "primary"
    useMaterial3: false,
    appBarTheme: AppBarTheme(
      backgroundColor: Colors.red, 
      elevation: 0
    ), //este es el estilo de la barra superior
  
    //color de los iconos en general
    iconTheme: IconThemeData(color: primary),

    //color de los iconos dentro de ListTile (leading y trailing)
    listTileTheme: ListTileThemeData(iconColor: primary),
  );
  



  //Tema halloween
  static final ThemeData halloweenTheme = ThemeData.dark().copyWith(

    primaryColor: Colors.red, //color primario, cuando queramos usarlos poner "primary"
    useMaterial3: false,
    appBarTheme: AppBarTheme(
      backgroundColor: Colors.deepOrange,
      elevation: 0,
    ),


    //color de los iconos en general
    iconTheme: IconThemeData(color: Colors.red),

    //color de los iconos dentro de ListTile (leading y trailing)
    listTileTheme: ListTileThemeData(iconColor: Colors.red),

    
  );
  
}
