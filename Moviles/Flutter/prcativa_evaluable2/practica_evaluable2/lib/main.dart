import 'package:flutter/material.dart';
import 'package:practica_evaluable2/providers/usuario_provider.dart';
import 'package:practica_evaluable2/screens/pantalla_dos.dart';
import 'package:practica_evaluable2/screens/pantalla_login.dart';
import 'package:practica_evaluable2/themes/tema_personalizado.dart';
import 'package:provider/provider.dart';


void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) => UsuarioProvider(),
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Material App',
        //theme: ThemeData(useMaterial3: false),
      
        routes: {
          "/": (BuildContext context) => Login(),
          "Pagina2": (BuildContext context) => PaginaDos(),
         
      
        },
      
        onGenerateRoute: (settings) =>MaterialPageRoute(builder: (context) => Login()),
      
       theme: AppTheme.lightTheme,
      ),
    );
  }
}