import 'package:componentes/presentation/widgets/cardPersonalizada1.dart';
import 'package:componentes/presentation/widgets/cardPersonalizada2.dart';
import 'package:flutter/material.dart';

class CardScreen extends StatelessWidget {
   
  const CardScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Tarjetas - Cards"),),
      body: ListView(
        padding: EdgeInsets.symmetric(horizontal: 20, vertical: 10),
        children: [
          CardTipo1(),
          CardTipo2(urlImagen: "https://imanesdeviaje.com/wp-content/uploads/2013/12/Lagos-de-Plitvice_11.jpg", texto: "Texto"),
          CardTipo2(urlImagen: "https://imanesdeviaje.com/wp-content/uploads/2013/12/Lagos-de-Plitvice_11.jpg")
          
        ],
      ),
      
    );
  }
}






