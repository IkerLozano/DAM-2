void main() {
  
  print('Inicio del programa');

  httpGet('http://www.google.es')
    .then( ((value) {
      print(value);
    }))
    .catchError( (err ) => print(err),)
    ;


  print('Fina del programa');

}


Future<String> httpGet(String url){

  return Future.delayed(Duration(seconds: 2), (){
    //return 'Respuesta de la peticion http';
    throw 'Error en la peticion';

  });

}