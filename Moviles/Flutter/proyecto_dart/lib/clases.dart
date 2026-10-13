void main() {
  
  final Heroe wolverine = Heroe(nombre: 'Logan', poder: 'regeneracion');

  print(wolverine);
  print(wolverine.nombre);
  print(wolverine.poder);
  print(wolverine.toString());

}

class Heroe {

  String nombre;
  String? poder;

  Heroe({
    required this.nombre,
    this.poder = 'Sin poder'

  });


  @override
  String toString() {

    return '$nombre - $poder';
  }

}