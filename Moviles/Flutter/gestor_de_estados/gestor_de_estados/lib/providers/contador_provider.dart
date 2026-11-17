//Este providr va a manejar el contador de la pagina 1

import 'package:flutter/material.dart';


//ChangeNotifaier es una clase que proporciona notificaciones a los Widgets cuando los Wiggets cambian el estado
class ContadorProvider extends ChangeNotifier {

  //cuando tenemos un estado con Providier hemos de poder hacer DOS cosas:
    //1- Poder leer el valor de ese valor
    //2- Poder modificar ese estado

    int _contador = 0;

    int get contador => _contador;

    void incrementar(){

      _contador++;
      notifyListeners(); //para notificar que ha habido un cambio

    }


}