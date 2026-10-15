void main()async {
  
  print('Inicio del programa');

  try {

      final value = await httpGet('Esta URL');
      print(value);

  } catch (err) {
    print('Tenemos un error: $err');
  }finally{

  }




  print('Final del programa');

}


Future<String> httpGet(String url)async {

  await Future.delayed(Duration(seconds: 3));
  throw 'Error de la peticion http';

  /*await Future.delayed(Duration(seconds: 2), (){
    return 'Respuesta de la peticion http';
    //throw 'Error en la peticion';

  });
  */

}