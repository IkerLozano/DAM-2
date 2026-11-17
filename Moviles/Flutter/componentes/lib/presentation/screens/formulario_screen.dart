import 'package:componentes/presentation/widgets/custom_input_field.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {
  const FormularioScreen({super.key}); // 1. Nombre de la clase en el constructor

  @override
  Widget build(BuildContext context) {


    //GlobalKey nos permite controlar y validar el formulario completo
    final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

    final Map<String, String> fromValues = {

      "firts_name"  : "Iker",
      "last_name" : "Lozano",
      "telefono" : "654123789",
      "email" : "ilozanor@iesch.org",
      "passwd" : "123123",
      "rol" : "Admin",

    }; 

    return Scaffold(
      appBar: AppBar(title: const Text("Formularios")),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 20),
          child: Form(
            key: _formKey,
            child: Column(
              children: [
                CustomInputField(labelText: "Nombre", hintText: "Nombre del usuario", formValues: fromValues,formProperties:"firts_name"),
                SizedBox(height: 20,),
                
                CustomInputField(labelText: "Apellidos", hintText: "Apellidos del usuario", formValues: fromValues,formProperties:"last_name"),
                SizedBox(height: 20,),
                
                CustomInputField(labelText: "Email", hintText: "Email del usuario", keyboardType: .emailAddress, formValues: fromValues,formProperties:"email"),
                SizedBox(height: 20,),
                
                CustomInputField(labelText: "Telefono", hintText: "Telefono del usuario", keyboardType: .phone, formValues: fromValues,formProperties:"telefono"),
                SizedBox(height: 20,),
                
                CustomInputField(labelText: "Contraseña", hintText: "Conttaseña del usuario", obscureText: true, formValues: fromValues,formProperties:"passwd"),
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
                    fromValues["rol"] = value ?? "Developer"; //si el valor es nulo devulve "developer"
                  }
                ),
                SizedBox(height: 20,),
                ElevatedButton(
                  onPressed: (){
                    print(fromValues);
                  }, 
                  child: Text("Guardar")
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}




