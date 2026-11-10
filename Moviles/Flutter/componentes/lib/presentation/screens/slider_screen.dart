import 'package:flutter/material.dart';

class SliderScreen extends StatefulWidget {
  // Corregido el nombre del constructor que tenía un error de sintaxis ('new')
  const SliderScreen({super.key});

  @override
  State<SliderScreen> createState() => _SliderScreenState();
}

class _SliderScreenState extends State<SliderScreen> {
  double _valorSlider = 60;
  bool _sliderActivado =
      true; // Cambiado a true para que el Slider empiece activo

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Slider & Checks")),
      body: Column(
        children: [
          Slider.adaptive(
            min: 30,
            max: 400,
            value: _valorSlider,
            // Si _sliderActivado es false, el Slider se deshabilita automáticamente
            onChanged: _sliderActivado
                ? (value) {
                    setState(() {
                      _valorSlider = value;
                    });
                  }
                : null,
          ),

          Checkbox.adaptive(
            value: _sliderActivado, // Usa el estado booleano
            onChanged: (value) {
              setState(() {
                _sliderActivado = value ?? false;
              });
            },
          ),

          Switch.adaptive(
            value: _sliderActivado, 
            onChanged: (value){
              _sliderActivado = value;
              setState(() {
                
              });
            }
          ),

          CheckboxListTile.adaptive(
            title: Text("Habilitar slider"),
            secondary: Icon(Icons.access_alarms),
            //subtitle: Text("Esto es el subtitulo"),
            titleAlignment: .center,
            value: _sliderActivado, 
            onChanged: (value){
              _sliderActivado = value ?? true;
              setState(() {
                
              });
            }
          ),

          SwitchListTile.adaptive(
            title: Text("Habilitar Slider"),
            value: _sliderActivado, 
            onChanged: (value){
              _sliderActivado = value;
              setState(() {
                
              });
            }
          ),

          Expanded(
            child: SingleChildScrollView(
              child: Image(
                image: NetworkImage("https://cdn.pixabay.com/photo/2020/07/06/17/51/batman-5377804_1280.png"),
                fit: BoxFit.contain,
                width: _valorSlider,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
