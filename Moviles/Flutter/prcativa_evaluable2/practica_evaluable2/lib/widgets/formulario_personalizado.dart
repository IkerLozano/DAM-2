import 'package:flutter/material.dart';

class MyWidget extends StatelessWidget {


  final String? hintText;
  final String? labelText;
  final String? helpText;
  final IconData? icon;
  //final IconData? suffixIcon;
  final TextInputType? keyboardType;
  final bool obscureText;
  //final Map<String, String> formValues;
  //final String formProperties;
  final TextEditingController? controller;

  const new({
    super.key,
    this.hintText,
    this.labelText,
    this.helpText,
    this.icon,
    //this.suffixIcon,
    this.keyboardType,
    this.obscureText = false,
    //equired this.formValues,
    //equired this.formProperties,
    this.controller,
  });

  @override
  Widget build(BuildContext context) {
    return Form(
      child: Column(
        children: [
          TextFormField(
            keyboardType: keyboardType,
            obscureText: obscureText,
            controller: controller,
            decoration: InputDecoration(
              labelText: labelText,
              hintText: hintText,
              prefixIcon: icon == null ? null : Icon(icon),
            ),
          ),

        
        ],
      ),
    );
  }
}
