import 'package:componentes/models/menu_options.dart';
import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});
  
  @override
  Widget build(BuildContext context) {

    final menuOptions = <MenuOptions>[

      MenuOptions(ruta: "ListView1", icono: Icons.list_alt, nombre: "ListView Tipo 1"),
      MenuOptions(ruta: "ListView2", icono: Icons.list, nombre: "ListView Tipo 2"),
      MenuOptions(ruta: "Alert", icono: Icons.add_alert, nombre: "Alertas - Alerts"),
      MenuOptions(ruta: "Card", icono: Icons.list_alt, nombre: "Tarjetas - Cards"),

    ];


    return Scaffold(
      appBar: AppBar(
        title: const Text("Componentes en Flutter"),
      ),
      body: ListView.separated(
        itemBuilder: (context, i) => ListTile(
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


          },
          trailing: const Icon(Icons.arrow_forward_ios, color: AppTheme.primary),
        ), 
        separatorBuilder: (_, __) => const Divider(), 
        itemCount: menuOptions.length,
      ), 
    );
  }
}


