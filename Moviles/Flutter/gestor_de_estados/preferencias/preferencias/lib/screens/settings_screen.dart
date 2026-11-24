import 'package:flutter/material.dart';
import 'package:preferencias/config/preferences/preferencias.dart';

class SettingsScreen extends StatefulWidget {
  const SettingsScreen({super.key});

  @override
  State<SettingsScreen> createState() => _SettingsScreenState();
}

class _SettingsScreenState extends State<SettingsScreen> {

/*

  bool _permisoUbicacion = false;
  bool _permisoCamara = false;
  bool _temaOacuro = false;
  String _nombre = " ";

*/

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Preferencias")),
      body: Column(
        children: [
          SwitchListTile.adaptive(
            title: Text("Permiso de ubicacion"),
            value: Preferencias.permisoUbicacion,
            onChanged: (value) {
              Preferencias.ubicacion = value!;
              setState(() {});
            },
          ),

          SwitchListTile.adaptive(
            title: Text("Permiso de Camara"),
            value: Preferencias.permisoCamara,
            onChanged: (value) {
              Preferencias.camara = value!;
              setState(() {});
            },
          ),

          SwitchListTile.adaptive(
            title: Text("Tema dark"),
            value: Preferencias.darkMode,
            onChanged: (value) {
              Preferencias.temaOscuro = value!;
              setState(() {});
            },
          ),

          Divider(),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextFormField(
              initialValue: Preferencias.nombre,
              decoration: InputDecoration(
                label: Text("Nombre"),
                helperText: "Nombre de usuario"
              ),
              onChanged: (value){
                Preferencias.nombre = value;
              },
            ),
          )
        ],
      ),
    );
  }
}
