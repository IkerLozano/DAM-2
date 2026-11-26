import 'package:api_rest1/models/post.dart';
import 'package:http/http.dart' as http;


class PostsService {

  //hacemos la peticion al API para solicitar la lista de posts 
  Future<List<Post>?> obtenerPosts() async{

    //creamos un cliente HTTP que nos va a permitir enciar la peticion
    var cliente = http.Client();

    //convertimos la direccion o endpoint e un objeto Uri
    var uri = Uri.parse("https://jsonplaceholder.typicode.com/posts"); //url de la api

    //enviamos la peticion GET y esperamos la respuesta del servidor
    var respuesta = await cliente.get(uri);

    //El codigo 200 indica que la peticion se ha realizado correctamente
    if  (respuesta.statusCode == 200) {
      var json = respuesta.body;

      //decodificamos ese texto y transformamos cada elemento JSON en un objeto post
      return postFromJson(json);
    }

    //si no es 200 no se devulve ninguna lista (null)
    

  }

}
