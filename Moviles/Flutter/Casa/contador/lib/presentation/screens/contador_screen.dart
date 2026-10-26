import 'package:contador/presentation/widgets/boton_personalizado.dart';
import 'package:flutter/material.dart';

//darle a la bombilla para camiar a StatefulWidget
class ContadorScreen extends StatefulWidget {
  const new({super.key}); //constructor, permite crear la pantalla.


  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
  /*
    _ContadorScreenState --> es la clase donde se guarda el contador y se construye la interfaz.
  */
}




class _ContadorScreenState extends State<ContadorScreen> {
  int contador = 0;

 @override
  Widget build(BuildContext context) {
    return Scaffold(
      // ----- La bombillica carrea dart
      // ----- Añado una barra arriba
      appBar: AppBar(
        title: Text("Contador App"),
        centerTitle: true,
        backgroundColor: Colors.blue.shade100, //color para la cabecera y cambio la transparencia
        //arriba a la derecha se a puesto un icono de refresh, le indico que al darle se ponga a 0
        //leading: IconButton(
        //  onPressed: (){
        //    contador = 0;
        //    setState(() {});
        //  }, 
        //  icon: Icon(Icons.refresh_rounded)),
          //aqui podemos meter muchos widgets
          actions: [
            IconButton(
          onPressed: (){
            contador = 0;
            setState(() {});
          }, 
          icon: Icon(Icons.refresh_rounded)),
          ],
      ),
      // CUERPO
      body: Center(
        child: Column(
          // ----- Le digo que la columna los posicione en el centro
          // ----- Si se tiene que usar la clase otra vez para sacar algún valor solo hace falta un "."
          mainAxisAlignment: .center,
          children: [
            // ----- Se pueden añadir propiedades al widget 
            Text(
              contador.toString(), 
              style: TextStyle(
                fontSize: 160,
                fontWeight: .w100
              ),
            ),
            //mensaje de click
            Text(
              "Click${contador == 1 ? '' : 's'}",
              style: TextStyle(
                fontSize: 45
              ),
              ),
              /*
              if  (contador != 1) Text('Cliks', style: TextStyle(fontSize: 25),),
              if  (contador == 1) Text('Clik', style: TextStyle(fontSize: 25),),
              */
          ],
          ),
      ),

      floatingActionButton: Column(
        mainAxisAlignment: .end,
        children: [
          //BOTON 1
          BotonCustom(icono: Icons.plus_one, onPressed: (){
            contador++;
            setState(() {
              
            });
          }),
          SizedBox(height: 10,),
          //BOTON 2
          BotonCustom(icono: Icons.exposure_minus_1, onPressed: (){
            contador--;
            setState(() {
              
            });
          }),
          SizedBox(height: 10,),
          //BOTON 3
          BotonCustom(icono: Icons.refresh_rounded, onPressed: (){
            contador = 0;
            setState(() {
              
            });
          }),
          SizedBox(height: 10,),
           
        ]
      )



      // ----- Botónes
      // ----- Con la bombillica se pueden extraer métodos  
      //floatingActionButton: Column(
      //mainAxisAlignment: .end,
      //children: [
      //  BotonPersonalizado(icono: Icons.refresh_rounded,),
      //  SizedBox(height: 10,),        
      //  BotonPersonalizado(icono: Icons.plus_one,),        
      //  SizedBox(height: 10,),        
      //  BotonPersonalizado(icono: Icons.exposure_minus_1,),              
      //  ],
      //)
    );
  }




/*
 FloatingActionButton customButton() {
   return FloatingActionButton(
        shape: StadiumBorder(), //para redondear el boton
        child: Icon(Icons.exposure_minus_1),
        onPressed: (){ 
          //hago que no peuda ser menor de 0
          if (contador > 0) contador--;
          setState(() {});
        },
      );
 }
*/

}

class BotonCustom extends StatelessWidget {

  final IconData icono;
  final VoidCallback? onPressed;

  const new({super.key, required this.icono, this.onPressed});



  @override
  Widget build(BuildContext context) {

    return FloatingActionButton(
      
      onPressed: onPressed,
      child: Icon(icono),

    );

  }


}



