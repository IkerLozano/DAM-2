//aqui se cargaran los psts
import 'package:api_rest1/models/post.dart';
import 'package:api_rest1/servicios/posts_service.dart';
import 'package:flutter/material.dart';

class PostsScreen extends StatefulWidget {
   
  const PostsScreen({super.key});

  @override
  State<PostsScreen> createState() => _PostsScreenState();
}

class _PostsScreenState extends State<PostsScreen> {

  //Lista de posts: la inicializo a null mientras no haya datos sisponibles
  List<Post>? listaPosts;
  //inidicador para decir su esta cragando o ha terminado la carga
  bool isLoading = false;


  @override
  void initState() {
    
    super.initState();
    //todo: aqui iniciare la carga de los Post de la API
    obtenerPosts();
  }

  void obtenerPosts() async {

    listaPosts = await PostsService().obtenerPosts();

    //aqui solo marcaremos l acraga como completyada si se recibio una respuesta valida

    if(listaPosts != null ){
      setState(() {
        isLoading = true;
      });
    }

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Posts"),),
      body: Visibility(
        visible: isLoading,
        replacement: Center(child: CircularProgressIndicator(),),
        child: ListView.builder(
          itemCount: listaPosts?.length,
          itemBuilder: (context, index)  {
            return Padding(
              padding: const EdgeInsets.all(8.0),
              child: Row(
                children: [
                  Container(
                    height: 50,
                    width: 50,
                    decoration: BoxDecoration(
                      borderRadius: .circular(12),
                      color: Colors.lightBlueAccent[100]
                    ),
                  ),
                  SizedBox(width: 16,),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: .start,
                      children: [
                        Text(listaPosts![index].title, maxLines: 2, overflow: .ellipsis, style: TextStyle(fontSize: 24, fontWeight: .bold),),
                        Text(listaPosts![index].body ?? '', maxLines: 3, overflow: .ellipsis,),
                      ],
                    ),
                  ),
                ],
              ),
            );
          }
        )
      )
      
    );
  }

  
}