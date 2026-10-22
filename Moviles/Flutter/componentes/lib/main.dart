import 'package:componentes/presentation/screens/listView2_screen.dart';
import 'package:componentes/presentation/screens/listview_screen.dart';

import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Material App',
      home: Listview2Screen() // ¡Ahora sí encuentra la clase correctamente!
    );
  }
}
