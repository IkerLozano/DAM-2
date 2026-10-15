
void main() {
  
  
  emitirNumeros()
    .listen( (event) {
      print('Valor del Stream: $event');
    });
  

}


Stream<int> emitirNumeros() async*{

  final valoresParaEmitir = [6,7,8,9,10];

  for(int i in valoresParaEmitir){
    await Future.delayed(Duration(seconds: 1));
    yield i;
  }

}