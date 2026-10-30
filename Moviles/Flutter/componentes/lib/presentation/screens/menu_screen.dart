import '../screens.dart';


class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});
  

  //LA BASE ES LA MISMA DE LA FORMA 2
  @override
  Widget build(BuildContext context) {


    


    //lista de opciones para mostrar en la pantalla, esto lo indicamoe en el "menu_options"
    final menuOptions = <MenuOptions>[

      MenuOptions(ruta: "ListView1", icono: Icons.list_alt, nombre: "ListView Tipo 1"),
      MenuOptions(ruta: "ListView2", icono: Icons.list, nombre: "ListView Tipo 2"),
      MenuOptions(ruta: "Alert", icono: Icons.add_alert, nombre: "Alertas - Alerts"),
      MenuOptions(ruta: "Card", icono: Icons.list_alt, nombre: "Tarjetas - Cards"),
      MenuOptions(ruta: "Button", icono: Icons.radio_button_on_outlined, nombre: "Botones - Buttons"),

    ];


    return Scaffold(

      appBar: AppBar(
      title: const Text("Componentes en Flutter"),
      ),

      body: ListView.separated(

        itemBuilder: (context, i) => ListTile(
          //cada "i" e sn elemento

          leading: Icon(menuOptions[i].icono), 
          title: Text(menuOptions[i].nombre),
          onTap: () { //para ir a esa pagina

            //FORMA 1 DE IR A ESA PAGINA
            /*final route = MaterialPageRoute(
              builder: (context) => Listview2Screen(),
            );

            Navigator.push(context, route);
            */


            //FORMA 2 DE IR A ESA PAGINA (MJR)
            Navigator.pushNamed(context, menuOptions[i].ruta);
                /*
                  Navigator: permite navegar entre pantallas.
                  pushNamed(...): abre una pantalla utilizando el nombre de una ruta.
                  context: permite localizar el contexto de navegación.
                  menuOptions[i].ruta: obtiene el nombre de la ruta correspondiente a la fila pulsada.
                */


          },
          trailing: const Icon(Icons.arrow_forward_ios, /*color: AppTheme.primary*/),
        ), 


        separatorBuilder: (_, __) => const Divider(), 
        itemCount: menuOptions.length,
      ), 
    );
  }
}


