import '../screens.dart';


class CardTipo1 extends StatelessWidget {

  const CardTipo1({super.key,});

  @override
  Widget build(BuildContext context) {
    return Card(
      //elevation: 5, //sombra para la tarjeta
      child: Column( //coloca todo uno debajo de otro *******
        children: [
          ListTile( //podemos crear una fila con un titulo, subtitulo ....
            leading: Icon(Icons.photo_album_outlined),
            title: Text("Titulo de la card"),
            subtitle: Text("Nostrud Lorem pariatur sunt non nisi sint et non mollit esse ipsum aliquip exercitation."),
          ),
          Padding(
            padding: const EdgeInsets.only(right: 7), //solo a la derecha
            child: Row(//coloca los botones en horizontal (___)
              mainAxisAlignment: .end, //los alineamos a la derecha
              children: [
                TextButton(onPressed: (){}, child: Text("Cancelar")),
                TextButton(onPressed: (){}, child: Text("Ok")),
              ],
            ),
          )
        ],
      ),
    );
  }
}