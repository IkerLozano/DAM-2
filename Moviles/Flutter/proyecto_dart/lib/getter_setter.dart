void main(){

  final miCuadrado = Cuadrado(lado: -7);

  print('Area: ${miCuadrado.area}' );

}

class Cuadrado{

  double _lado;

  Cuadrado({required double lado})
    : assert(lado >= 0, "El lado debe ser mayor a 0"),
      assert(lado < 10, "El lado no puede ser mayor a 10"),
     _lado = lado;



  //getter
  double get area {
    return _lado * _lado;
  }

  //setter
  set lado(double valor){
    print('El nuevo valor es $valor');

    if(valor < 0) throw 'El valor debe ser mayor de 0';
    _lado = valor;
  }

  
}