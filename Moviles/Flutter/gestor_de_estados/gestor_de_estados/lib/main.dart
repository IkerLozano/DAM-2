import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:gestor_de_estados/screens/home_screen.dart';
import 'package:provider/provider.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      //con envolver widget
      providers: [
        ChangeNotifierProvider(create: (context) => ContadorProvider())
      ],
      child: MaterialApp(
        title: 'Gestor de estados',
        home: HomeScreen(),
        debugShowCheckedModeBanner: false,
      ),
    );
  }
}
