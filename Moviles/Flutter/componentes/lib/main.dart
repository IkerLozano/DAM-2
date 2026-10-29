
import 'presentation/screens.dart'; //desde el archivo screens nos traemos todos los imports

 



void main() => runApp(const MyApp());


class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false, //quitar la etiqueta
      title: 'Material App', //título general de la aplicación.(no es visible)
      //home: Listview2Screen(), con esto le indicamos cual seria la pantalla de inicio de la app


      initialRoute: "/", //pagina inicial de la app,  se sule poner con una "/", pero se puede poner lo que sea
      
      //asocia la pagina conunu nomvre, para que ea mas facil usarlas
      routes: {
        "/"       : (BuildContext context) => HomeScreen(),
        "ListView1"  : (BuildContext context) => ListviewScreen(),
        "ListView2"  : (BuildContext context) => Listview2Screen(),
        "Alert"      : (BuildContext context) => AlertScreen(),
        "Card"       : (BuildContext context) => CardScreen(),
        "Button"     : (BuildContext context) => BotonesScreen(),
      },

      //gestiona donde vamos si la ruta no existe, ira a "HomeScreen"
      onGenerateRoute: (settings) => MaterialPageRoute(builder: (context) => HomeScreen(),),

      //llamo al archivo de los temas comunes
      theme: AppTheme().getTheme() //esto necesita que le pasemos un theme, si le pasamos un color (primary) dara error
        //halloweenTheme
        //().getTheme()

    );
  }
}
