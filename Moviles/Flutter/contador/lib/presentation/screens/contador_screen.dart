import 'package:contador/presentation/widgets/boton_personalizado.dart';
import 'package:flutter/material.dart';

//darle a la bombilla para camiar a StatefulWidget
class ContadorScreen extends StatefulWidget {
  const new({super.key});

  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}

class _ContadorScreenState extends State<ContadorScreen> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Contador App"),
        centerTitle: true, //lo centra
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: .center,
          children: [
            Text(
              '$contador',
              style: TextStyle(fontSize: 160, fontWeight: .w100),
            ),
            Text("Cliks", style: TextStyle(fontSize: 25)),
          ],
        ),
      ),
      floatingActionButton: Column(
        mainAxisAlignment: .end,
        children: [
          BotonPersonalizado(icono: Icons.refresh_rounded,),
          SizedBox(height: 10,),
          BotonPersonalizado(icono: Icons.plus_one,),
          SizedBox(height: 10,),
          BotonPersonalizado(icono: Icons.exposure_minus_1,),

        ],
      ),
    );
  }
}


