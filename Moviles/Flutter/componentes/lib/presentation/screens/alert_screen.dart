import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class AlertScreen extends StatelessWidget {
   
  const AlertScreen({super.key});
  
  void mostrarAlerta(BuildContext context){

    showDialog(
      context: context, 
      builder: (context) {
        return AlertDialog(
          title: Text("Titulo de la alerta"),
          content: Column( //sin el column hace lo mismo
            mainAxisSize: .min,
            children: [
              Text("Este es el contenido de la alerta"),
              SizedBox(height: 20),
              FlutterLogo(size: 100,) //logo de flutter
            ],
          ),
        );
    },);

  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Alertas'),
        //backgroundColor: Colors.red,
        //elevation: 30, //sombra
      ),
      body: Center(
         child: ElevatedButton(
          style: ElevatedButton.styleFrom(
            backgroundColor: AppTheme.primary,
            shape: StadiumBorder() //redondear el boton
          ),
          onPressed: (){
            mostrarAlerta(context);
          }, 
          child: Padding(
            padding: const EdgeInsets.all(25), //padding de toda la vida
            child: Text('Mostrar alerta'),
          )
          ),
      ),
    );
  }
}