import 'package:api_rest1/models/user.dart';
import 'package:dio/dio.dart';

class UserService {

  //Metodo para obtener la lista de usuarios usando DIO

  static Future<List<dynamic>> obtenerUsuarioConDIO() async{

    final dio = Dio();
    final respuesta = await dio.get("https://jsonplaceholder.typicode.com/users");

    if  (respuesta.statusCode == 200 ){

        return respuesta.data;

    }else{

      throw Exception("Error al cargar los usuarios con DIO");

    }

  }

}