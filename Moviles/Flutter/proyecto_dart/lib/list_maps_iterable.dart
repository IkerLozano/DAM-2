void main() {

  final nums = [1,2,3,4,5,5,6,7,7,8,9];

  print('Lista original: $nums');
  print('Longutud: ${nums.length }');
  print('Index 0: ${nums[0] }');
  print('Primero: ${nums.first }');
  //print('Reversed: ${nums.reversed }');



  final reversedNums = nums.reversed;
  print('Iterable: $reversedNums');
  print('Lista: ${reversedNums.toList()}'); //lo paso a lista
  print('Set: ${reversedNums.toSet()}');

  final numsMasQue5 = nums.where ((int num){
    return num > 5; //true
  });

  print('Numeros mayores de 5: $numsMasQue5');
}