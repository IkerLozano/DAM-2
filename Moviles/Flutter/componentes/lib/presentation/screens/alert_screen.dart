import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class AlertScreen extends StatelessWidget {
  const AlertScreen({super.key});

  //VENTANA EMERGENTE DE LA ALERTA
  void mostrarAlerta(BuildContext context) {
    showDialog(
      //nos muetsra una nueva ventana
      context: context,
      builder: (context) {
        return AlertDialog(
          title: Text("Titulo de la alerta"),
          //desde aqui es lo que va a contener la alerta
          content: Column(
            mainAxisSize: .min, //ajusta el espacio, para que ocupe lo necesario
            children: [
              //widgets de la alerta
              Text("Este es el contenido de la alerta"),
              SizedBox(height: 20), //esapcio
              FlutterLogo(size: 100), //logo de flutter
            ],
          ),
        );
      },
    );
  }

  //CONSTRUYE LA PANTALLA COMPLETA(Barra superior, botón, fondo)
  //siempre que ponga buils esq esta se está construyendo la interfaz
  //dentro del onPresed se podriaponer el showDialog de arriba peropara  quede mas ordenado se hace asi
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //barra superior
      appBar: AppBar(title: Text('Alertas')),

      //cuerpo de la pantalla
      body: Center(
        child: ElevatedButton( //child: indica cuál es el widget hijo que contiene otro widget

          //estilo del boton
          style: ElevatedButton.styleFrom(
            //crea un estilo para el botón
            backgroundColor: Colors.deepOrange,
            shape: StadiumBorder(), //redondear el boton
          ),

          //accion del boton
          onPressed: () {
            //cuando se presione
            mostrarAlerta(context); //lama al metodo que muestra la alerta
          },
          child: Padding(
            padding: const EdgeInsets.all(25), //padding por cada lado
            child: Text('Mostrar alerta'),
          ),
        ),
      ),
    );
  }
}
