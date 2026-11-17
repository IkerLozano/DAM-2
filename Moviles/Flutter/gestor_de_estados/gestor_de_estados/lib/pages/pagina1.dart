import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:provider/provider.dart';

class Pagina1 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
     backgroundColor: Colors.lightBlue,
     body: Column(
      children: [
        Center(child: Text(context.watch<ContadorProvider>().contador.toString(), 
                      style: TextStyle(fontSize: 120),),),
        ElevatedButton(
          onPressed: () {
            //aqui vamos a acceder al provider y llamar a la funcion incrementar
            context.read<ContadorProvider>().incrementar();
        }, 
        child: Text("Incrementar"))
      ],
     ),
    );
  }
}