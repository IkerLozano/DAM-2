import 'package:flutter/material.dart';
import 'package:preferencias/config/preferences/preferencias.dart';
import 'package:preferencias/screens/settings_screen.dart';

void main() async { 

  await Preferencias.init();

 runApp(const MyApp());

}


class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    bool tema = Preferencias.darkMode;
    return MaterialApp(
      debugShowCheckedModeBanner: false,

      title: 'Share preferences',
      home: SettingsScreen(),
      theme : tema ? .dark() : .light(),
      darkTheme: ThemeData.dark(),
    );
  }
}
