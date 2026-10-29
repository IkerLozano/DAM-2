

import 'package:flutter/material.dart';

class CardTipo1 extends StatelessWidget {
  const new({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      //elevation: 0,
      child: Column(
        children: [
          ListTile(
            leading: Icon(Icons.photo_album_outlined),
            title: Text("Titulo de la card"),
            subtitle: Text("Nostrud Lorem pariatur sunt non nisi sint et non mollit esse ipsum aliquip exercitation."),
          ),
          Padding(
            padding: const EdgeInsets.only(right: 7),
            child: Row(//botones a la derecha
              mainAxisAlignment: .end,
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