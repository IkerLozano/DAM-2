import 'package:api_rest1/models/user.dart';
import 'package:api_rest1/servicios/user.service.dart';
import 'package:flutter/material.dart';

class UserScreen extends StatefulWidget {
  const UserScreen({super.key});

  @override
  State<UserScreen> createState() => _UserScreenState();
}

class _UserScreenState extends State<UserScreen> {
  late Future<List<dynamic>> _futureUsers;

  @override
  void initState() {
    super.initState();
    _futureUsers = UserService.obtenerUsuarioConDIO();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Lista de usuarios")),
      body: FutureBuilder(
        future: _futureUsers,
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            //para el estado
            return Center(child: CircularProgressIndicator.adaptive());
          } else if (snapshot.hasError) {
            return Center(child: Text("Error: ${snapshot.error}"),);
          }else{
            final listaUsuarios = snapshot.data!; //! --> seguro q no es nulo
            return ListView.builder(
              itemCount: listaUsuarios.length,
              itemBuilder: (context, index) {
                final  usuario = listaUsuarios[index];
                return ListTile(
                  title: Text(usuario["name"]),
                  subtitle: Text(usuario["address"]["street"]),
                );
              },
            );
          }
        },
      ),
    );
  }
}
