import 'package:shared_preferences/shared_preferences.dart';

class Preferencias {
  static late SharedPreferences _preferencias;

  //1- Aqui creo las propiedades globales que quiero manejar en mi app
  static bool _permisoUbicacion = false;
  static bool _permisoCamara = false;
  static bool _temaOacuro = false;
  static String _nombre = " ";

  static Future init() async {
    _preferencias = await SharedPreferences.getInstance();
  }

  //2- me tengo que crear los metodos que me devuelven los valores
  static String get nombre => _preferencias.getString("nombre") ?? _nombre;
  static bool get permisoUbicacion => _preferencias.getBool("ubicacion") ?? _permisoUbicacion;
  static bool get permisoCamara => _preferencias.getBool("camara") ?? _permisoCamara;
  static bool get darkMode => _preferencias.getBool("dark") ?? _temaOacuro;



  //3 - Me creo los setters
  static set nombre(String nombre) {
    _nombre = nombre;
    _preferencias.setString("nombre", nombre);
  }

  static set ubicacion(bool ubicacion) {
    _permisoUbicacion = ubicacion;
    _preferencias.setBool("ubicacion", ubicacion);
  }

  static set camara(bool camara) {
    _permisoCamara = camara;
    _preferencias.setBool("camara", camara);
  }

  static set temaOscuro(bool temaOscuro) {
    _temaOacuro = temaOscuro;
    _preferencias.setBool("dark", temaOscuro);
  }
}
