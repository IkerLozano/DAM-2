import 'package:componentes/presentation/widgets/custom_input_field.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {
  const FormularioScreen({super.key}); // 1. Nombre de la clase en el constructor

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Formularios")),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 20),
          child: Form(
            child: Column(
              children: [
                CustomInputField(labelText: "Nombre", hintText: "Nombre del usuario",),
                SizedBox(height: 20,),
                
                CustomInputField(labelText: "Apellidos", hintText: "Apellidos del usuario",),
                SizedBox(height: 20,),
                
                CustomInputField(labelText: "Email", hintText: "Email del usuario", keyboardType: .emailAddress,),
                SizedBox(height: 20,),
                
                CustomInputField(labelText: "Telefono", hintText: "Telefono del usuario", keyboardType: .phone,),
                SizedBox(height: 20,),
                
                CustomInputField(labelText: "Contraseña", hintText: "Conttaseña del usuario", obscureText: true,),
                SizedBox(height: 20,),
            
            
                DropdownButtonFormField(
                  initialValue: "Admin",
                  items: [
                    DropdownMenuItem(child: Text("Administrador"), value: "Admin"),
                    DropdownMenuItem(child: Text("SuperUsuario"), value: "SuperUsuario"),
                    DropdownMenuItem(child: Text("Developer"), value: "Developer"),
                    DropdownMenuItem(child: Text("Junior Developer"), value: "Junior Developer")
                  ], 
            
                  onChanged: (value) {
                    print(value);
                  }
                ),
                SizedBox(height: 20,),
                ElevatedButton(onPressed: null, child: Text("Guardar"))
              ],
            ),
          ),
        ),
      ),
    );
  }
}




