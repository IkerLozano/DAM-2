import 'package:flutter/material.dart';


class CustomInputField extends StatelessWidget {


  final String? hintText;
  final String? labelText;
  final String? helpText;
  final IconData? icon;
  final IconData? suffixIcon;
  final TextInputType? keyboardType;
  final bool obscureText;

  const new({
    super.key, 
    this.hintText, 
    this.labelText, 
    this.helpText, 
    this.icon, 
    this.suffixIcon, 
    this.keyboardType,
    this.obscureText = false
  });

 

  

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      //autofocus: true, // Cuando se carga la página se señala
      initialValue: "", // Texto por defecto
      textCapitalization: .words, //palabra en mayus (no me va)
      keyboardType: keyboardType, //para el tipo de entrada, email, telepfono
      obscureText: obscureText,
      onChanged: (value) {
        print(value);
      },
      validator: (value) {
        if (value == null) return "Este campo es requerido"; //esto no salta nunca
        return value.length <3 ? "Minimo de 3 carcateres" : null;
      },
      autovalidateMode: .onUserInteraction, //mensaje inferior para validar
      decoration: InputDecoration(
        hintText : hintText, //plaheolder 
        labelText: labelText, //etiqueta superior al empezar a escribir
        helperText: helpText, //mensaje abajo
        counterText: "Contador", //texto al final
        suffixIcon: suffixIcon == null ? null : Icon(suffixIcon), //icono izq
        //prefixIcon: Icon(Icons.account_circle), //icono der
        icon: icon == null ? null : Icon(icon),
        /*
        icon: Icon(Icons.assignment_ind),
        focusedBorder: OutlineInputBorder( //borde al pulsar
          borderSide: BorderSide(
            color: Colors.red,
          )
        ), //lo tira hacia la dercha
        border: OutlineInputBorder(
          borderRadius: .only( //bordes
            bottomLeft: Radius.circular(20),
            topRight: Radius.circular(10)
          ),
        )
        */
      ),
    );
  }
}