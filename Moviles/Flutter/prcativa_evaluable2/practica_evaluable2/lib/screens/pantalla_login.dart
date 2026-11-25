import 'package:flutter/material.dart';
import 'package:practica_evaluable2/providers/usuario_provider.dart';
import 'package:practica_evaluable2/screens/pantalla_dos.dart';
import 'package:practica_evaluable2/widgets/formulario_personalizado.dart';
import 'package:provider/provider.dart';

class Login extends StatefulWidget {
  const new({super.key});

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final usuarioController = TextEditingController();
  final passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Login"), centerTitle: true),

      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 20),
        child: Column(
          children: [
            MyWidget(
              labelText: "Usuario",
              hintText: "Introduce tu nombre de usuario",
              icon: Icons.person,
              keyboardType: .emailAddress,
              controller: usuarioController,
            ),
            SizedBox(height: 20),

            MyWidget(
              labelText: "Contraseña",
              hintText: "Introduce tu contraseña",
              icon: Icons.password,
              obscureText: true,
              controller: passwordController,
            ),
            SizedBox(height: 20),

            ElevatedButton.icon(
              onPressed: () {
                context.read<UsuarioProvider>().guardarDatos(
                  usuarioController.text,
                  passwordController.text,
                );

                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => PaginaDos()),
                );
              },
              label: Text("Logerarse"),
              icon: Icon(Icons.login),
            ),
          ],
        ),
      ),
    );
  }
}
