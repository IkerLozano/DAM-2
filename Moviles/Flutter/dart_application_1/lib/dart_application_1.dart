import 'dart:io';

void main() {

      String? nombre;

      print(nombre ?? "Sin nombre");

      List<String> alumnos = [
        "Andres",
        "Hecprolll",
        "Alons"
      ];

      alumnos.add("Pedro");
      
      for(var a in alumnos){
        print(a);
      }

}