import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart'; //desde el archivo screens (con todos los imports) los traemos

import 'presentation/screens.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false, //quitar la etiqueta
      title: 'Material App',
      //home: Listview2Screen(), ns pq se comenta esto


      initialRoute: "/", //la pagina inicial la pgina inicial se sule poner con una barra, pero se puede poner lo que sea
      //para enlazar paginas
      routes: {
        "/"       : (BuildContext context) => HomeScreen(),
        "ListView1"  : (BuildContext context) => ListviewScreen(),
        "ListView2"  : (BuildContext context) => Listview2Screen(),
        "Alert"      : (BuildContext context) => AlertScreen(),
        "Card"       : (BuildContext context) => CardScreen()
      },

      //gestiona donde vamos si la ruta no existe, ira a cardScreen
      onGenerateRoute: (settings) => MaterialPageRoute(builder: (context) => HomeScreen(),),

      //llamo al archivo de los temas comunes
      theme: AppTheme.lightTheme
      
    );
  }
}
