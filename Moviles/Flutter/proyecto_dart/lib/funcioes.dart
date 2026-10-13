void main() {

  print(saludar());
  print(saludar());
  print(sumarOpcional(5, 1)); //podemos solo pasarle 5 y no dara fallo
  print(saludoCompleto(mensaje: 'Que te den', nombre: 'Iker'));
}

String saludar(){

  return 'Hola Iker';
}

String saludar2() => 'Hola Iker' ;


int sumar(int a, int b){

  return a + b;
}

int sumar2(int a, int b) => a+b;

int sumarOpcional(int a, [int b = 0]) {

  return a+b;
}


//parametros con  nombre
String saludoCompleto({required String nombre, String mensaje = 'HOLA' }) {

    return '$mensaje $nombre';
}