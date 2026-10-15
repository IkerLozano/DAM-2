
void main() {
  
  emitirNumeros().listen( (event) {
    print('Valor del Stream: $event');
  });

}


Stream<int> emitirNumeros(){

  return Stream.periodic(Duration(seconds: 1), (value){

      return value;
  },).take(7);

}