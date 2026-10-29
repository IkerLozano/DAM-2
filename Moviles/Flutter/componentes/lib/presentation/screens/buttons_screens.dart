import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class BotonesScreen extends StatelessWidget {
  const BotonesScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Botones")),
      body: _Buttons(),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.arrow_back_ios),
        onPressed: () {},
      ),
    );
  }
}

class _Buttons extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView( //para que se pueda escrollear hacia abajo y no se desvorde la pagina
      child: SizedBox(
        width: double.infinity,
        child: Padding(
          // CORREGIDO: Cambiado a EdgeInsets.symmetric
          padding: EdgeInsets.symmetric(horizontal: 20, vertical: 20),//pading
          child: Column(
            children: [Column(
              children: [
                ElevatedButton(onPressed: () {}, child: Text("Elevated Button")),
                ElevatedButton(onPressed: null , child: Text("Elevated Button Disabled")), //si en el onPressed ponemos null el boton se desactiva
                
                // CORREGIDO: Se cerró el paréntesis del constructor al final
                ElevatedButton.icon(
                  onPressed: (){}, 
                  label: Text("Elevated Icon Button"),
                  icon: Icon(Icons.terminal),
                ), // <-- Coma añadida aquí
      
                // CORREGIDO: Coma añadida al final del botón FilledButton
                FilledButton(
                  onPressed: (){},
                  child: Text("Filled"),
                ),
                
                // CORREGIDO: Se cerró el paréntesis del constructor al final
                FilledButton.icon(
                  onPressed: (){}, 
                  label: Text("Filled"),
                  icon: Icon(Icons.dnd_forwardslash_outlined),
                  iconAlignment: IconAlignment.end, // CORREGIDO: Añadido IconAlignment
                ),
                OutlinedButton(onPressed: (){}, child: Text("Outlined")),
                
                // CORREGIDO: El 'icon' ahora está correctamente dentro de los paréntesis del OutlinedButton.icon
                OutlinedButton.icon(
                  onPressed: (){}, 
                  label: Text("Outlined Icon"),
                  icon: Icon(Icons.offline_pin),
                ),
                TextButton(onPressed: (){}, child: Text("TextButton")),
                TextButton.icon(onPressed: (){}, label: Text("TextButton icon"), icon: Icon(Icons.offline_pin),),
                IconButton(onPressed: (){}, icon: Icon(Icons.face_2_outlined)),
                IconButton(
                  onPressed: (){}, 
                  icon: Icon(Icons.face_2_outlined, size: 50, color: Colors.amber),
                  style: ButtonStyle(
                    backgroundColor: WidgetStatePropertyAll(Colors.red)
                  ),
                ),
      
                //nos creamos un boton personal
                SizedBox(height: 10,),//margin
                _BotonPersonalizado(),
      
                SizedBox(height: 10,),//margin
                _BotonPersonalizado(),
      
                SizedBox(height: 10,),//margin
                _BotonPersonalizado(),
      
                SizedBox(height: 10,),//margin
                _BotonPersonalizado(),
              ],
            ),
          ]),
        ),
      ),
    );
  }
}

//_ --> hace q sea privado
class _BotonPersonalizado extends StatelessWidget {

  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return ClipRRect( //redondearlo
      borderRadius: .circular(20),
      child: Material(
        color: Colors.red,
        child: InkWell( //para hacerlo clikable
          onTap: (){
        
          },
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Text("Mi propio boton"),
          ),
        ),
      ),
    );
  }
}
