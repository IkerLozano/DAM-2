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
      // ----- La bombillica carrea dart

      //BARRA SUPERIOR
      appBar: AppBar(
        title: Text("Contador App"),
        centerTitle: true, //centrado
        backgroundColor: Colors
            .blue
            .shade100, //color para la cabecera y cambio la transparencia
        //aqui podemos meter muchos widgets
        actions: [
          IconButton(
            //Crea un botón con un icono.
            onPressed: () {
              //Define qué ocurre al pulsar el botón.
              contador = 0;
              setState(() {}); //actualiza la pantalla
            },
            icon: Icon(Icons.refresh_rounded), //el icono
          ),
        ],
      ),



      // CUERPO
      body: Center(
        child: Column(
          //Coloca los widgets en vertical (uno debajo de otro)
          // ----- El "." es lo mimo que "mainAxisAlignment: MainAxisAlignment.center"
          mainAxisAlignment: .center,
          children: [
            //lista de widgets que contiene la columna

            //numero del contador
            Text(
              contador
                  .toString(), //lo ponemos en String para poder usar el style
              style: TextStyle(fontSize: 160, fontWeight: .w100),
            ),

            //mensaje de click
            Text(
              "Click${contador == 1 ? '' : 's'}",
              style: TextStyle(fontSize: 45),
              /*
                  if  (contador != 1) Text('Cliks', style: TextStyle(fontSize: 25),),
                  if  (contador == 1) Text('Clik', style: TextStyle(fontSize: 25),),
              */
            ),
          ],
        ),
      ),

      //BOTONES QUE MODICAN EL CONTADOR
      floatingActionButton: Column( //un boton encima de otro
        mainAxisAlignment: .end,

        children: [ //lista de widgets
          //BOTON 1
          BotonCustom(
            icono: Icons.plus_one,
            onPressed: () { //define lo que pasa cuando se pulsa el boton
              contador++;
              setState(() {});
            },
          ),
          SizedBox(height: 10), //espacio entre botones


          //BOTON 2
          BotonCustom(
            icono: Icons.exposure_minus_1,
            onPressed: () {
              //if (contador == 1) contador--;    --> para no poder ser negativo
              contador--;
              setState(() {});
            },
          ),
          SizedBox(height: 10),


          //BOTON 3
          BotonCustom(
            icono: Icons.refresh_rounded,
            onPressed: () {
              contador = 0;
              setState(() {});
            },
          ),
          SizedBox(height: 10),
        ],
      ),


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

  //esto es lo que recibe, cuando lo usemos le tenemos que pasar esto
  final IconData icono; //icono
  final VoidCallback? onPressed; //la accion al presionar
  /*
    VoidCallback: representa una función que no recibe parámetros ni devuelve ningún valor.
    ?: indica que puede ser null, es decir, que puedes no pasarle ninguna función.
  */

  //el constructor
  const BotonCustom({super.key, required this.icono, this.onPressed});

  @override
  Widget build(BuildContext context) {
    return FloatingActionButton(onPressed: onPressed, child: Icon(icono));
  }
}
