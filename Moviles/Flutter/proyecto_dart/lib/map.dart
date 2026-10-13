void main() {

  //los maps son pares de valores
  final Map<String, dynamic> pokemon = {
    'nombre': 'Dito',
    'hp' :   100,
    'isAlive' : true,
    'spirits' : {
       1 : 'ditto/front.jpg',
       2 : 'ditto/back.jpg'
    }
  };
  
  print(pokemon);
  print('Nombre:  ${pokemon['nombre']}');
  print('Nombre:  ${pokemon['spirits']}');
  
  print('Back: ${pokemon['spirits'][2] }');
  print('Front: ${pokemon['spirits'][1] }');
  
}
