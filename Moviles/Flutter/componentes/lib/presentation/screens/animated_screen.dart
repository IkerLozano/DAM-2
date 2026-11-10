import 'dart:math';

import 'package:flutter/material.dart';

class AnimatedScreen extends StatefulWidget {
  const new({super.key});

  @override
  State<AnimatedScreen> createState() => _AnimatedScreenState();
}

class _AnimatedScreenState extends State<AnimatedScreen> {

  double _width = 50;
  double _height = 50;

  Color _color = Colors.indigo;

  BorderRadiusGeometry _radio = BorderRadius.circular(10);

  void cambiarShape(){

    final random = Random();
    _width = random.nextInt(300).toDouble()+70;
    _height = random.nextInt(300).toDouble()+70;

    _color = Color.fromRGBO(
      random.nextInt(255),
      random.nextInt(255),
      random.nextInt(255),
      1
    );

    _radio = BorderRadius.circular(random.nextInt(100).toDouble() + 10);

    setState(() {
      
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Animated Container"),),
      body: Center(
        child: AnimatedContainer(
          duration: Duration(milliseconds: 400),
          curve: Curves.easeInOutCubic,
          width: _width,
          height: _height,
          decoration: BoxDecoration(
            color: _color,
            borderRadius: _radio
          ),
        ),
      ),

      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.play_circle_outline_outlined),
        onPressed: () => cambiarShape()
      ),
    );
  }
}