import 'package:flutter/material.dart';
import 'package:practica_evaluable/Theme/app_theme.dart';
import 'package:practica_evaluable/presentation/screens/pagina1.dart';
import 'package:practica_evaluable/presentation/screens/pagina2.dart';
import 'package:practica_evaluable/presentation/screens/pagina3.dart';
import 'package:practica_evaluable/presentation/screens/pagina4.dart';
import 'package:practica_evaluable/presentation/screens/pagina5.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      //theme: ThemeData(useMaterial3: false),

      routes: {
        "/": (BuildContext context) => Home(),
        "Pagina2": (BuildContext context) => Pagina2(),
        "Pagina3": (BuildContext context) => Pagina3(),
        "Pagina4": (BuildContext context) => Pagina4(),
        "Pagina5": (BuildContext context) => Pagina5(),

      },

      onGenerateRoute: (settings) =>MaterialPageRoute(builder: (context) => Home()),

      theme: AppTheme.lightTheme
    );
  }
}
