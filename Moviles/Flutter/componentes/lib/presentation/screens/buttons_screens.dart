import '../screens.dart';

class BotonesScreen extends StatelessWidget {
  const BotonesScreen({super.key});

  //pantalla principal
  //como se crea el Scaffold
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Botones")),
      body: _Buttons(), //aqui metemos el contenido de la pagina, para no hacerlo larguismo creamos una clase con los botones y luego la llamamos aqui
      floatingActionButton: FloatingActionButton(
        //boton flotante de la derecha abajo
        child: Icon(Icons.arrow_back_ios),
        onPressed: () {},
      ),
    );
  }
}

//aqui creo los botones y luego llamo a esta funcion desde la funcion build
class _Buttons extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      //para que se pueda escrollear hacia abajo y no se desborde la pagina
      child: SizedBox(
        //SizedBox --> es para poder poner espaciados en la pagina
        width: double.infinity, //ocupa todo el ancho posible
        child: Padding(
          //espacio al rededor del hijo
          padding: EdgeInsets.symmetric(
            horizontal: 20,
            vertical: 20,
          ), //el mismo pading para todos los lados
          child: Column(
            children: [
              
              //=====TIPOS DE BOTONES=====

              //BOTON1, boton normal
              ElevatedButton(onPressed: () {}, child: Text("Elevated Button")),

              //BOTON2, el mismo de arriba pero desactivado
              ElevatedButton(
                onPressed: null,
                child: Text("Elevated Button Disabled"),
              ), //si en el onPressed ponemos null el boton se desactiva
              //BOTON3, boton con icono y texto
              ElevatedButton.icon(
                onPressed: () {},
                label: Text("Elevated Icon Button"),
                icon: Icon(Icons.terminal),
              ),

              //BOTON4, boton con color de fodo
              FilledButton(onPressed: () {}, child: Text("Filled")),

              //BOTON4, el mismo de arriba pero con icono
              FilledButton.icon(
                onPressed: () {},
                label: Text("Filled"),
                icon: Icon(Icons.dnd_forwardslash_outlined),
                iconAlignment:
                    IconAlignment.end, //posicion del icono en el boton
              ),

              //BOTON5, con borde y sin color de fondo
              OutlinedButton(onPressed: () {}, child: Text("Outlined")),

              //BOTON6, lo mimso que arriba pero con icono
              OutlinedButton.icon(
                onPressed: () {},
                label: Text("Outlined Icon"),
                icon: Icon(Icons.offline_pin),
              ),

              //BOTON7, sin fondo ni borde, solo se ve la letra
              TextButton(onPressed: () {}, child: Text("TextButton")),

              //BOTON8, lo mismo que el 7 pero con icono
              TextButton.icon(
                onPressed: () {},
                label: Text("TextButton icon"),
                icon: Icon(Icons.offline_pin),
              ),

              //BOTON9, solo se ve el icono
              IconButton(onPressed: () {}, icon: Icon(Icons.face_2_outlined)),

              //BOTON9, lo mismo que el 9 pero personalizamos el icono
              IconButton(
                onPressed: () {},
                icon: Icon(
                  Icons.face_2_outlined,
                  size: 50,
                  color: Colors.amber,
                ),
                style: ButtonStyle(
                  backgroundColor: WidgetStatePropertyAll(Colors.red),
                ),
              ),

              //BOTONES PERSONALIZADOS
              SizedBox(height: 10), //margin
              _BotonPersonalizado(),

              SizedBox(height: 10), //margin
              _BotonPersonalizado(),

              SizedBox(height: 10), //margin
              _BotonPersonalizado(),

              SizedBox(height: 10), //margin
              _BotonPersonalizado(),
            ],
          ),
        ),
      ),
    );
  }
}

//aqui hago mi boton personalizado
//_ --> hace q sea privado
class _BotonPersonalizado extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return ClipRRect(
      //redondear las esquinas, pero le tenemos que indicar cuanto la redondeamos
      borderRadius: .circular(20), //aqui se lo indicamos
      child: Material(
        //Material --> nos permite pponer funciones de diseño, con esto creo el fondo rojo
        color: Colors.red,
        child: InkWell(
          //para hacerlo clikable
          onTap: () {
            print("Has pulsado mi botón"); //lo saca por consola
          },
          child: Padding(
            //esapcio de dentro del boton
            padding: const EdgeInsets.all(20.0), //lo mismo por los 4 lados
            child: Text("Mi propio boton"),
          ),
        ),
      ),
    );
  }
}

/*
  EdgeInsets.symmetric(horizontal: 20, vertical: 20)
  EdgeInsets.all(20.0)


  Ambos añaden 20 píxeles en los cuatro lados. 
  La diferencia es que all aplica el mismo valor a todos los lados, 
  mientras que symmetric permite definir los valores horizontal y vertical por separad
*/
