
import 'package:flutter/material.dart';

class AppTheme {
  AppTheme._();

  // Colores
  static const Color primary = Color(0xFF263238);
  static const Color background = Colors.white;
  static const Color borderIdle = Color(0xFFBDBDBD);
  static const Color hint = Color(0xFFB0B0B0);
  static const Color textColor = Colors.black;

  static const double _radius = 3;

  static final ThemeData lightTheme = ThemeData(
    useMaterial3: false,
    brightness: Brightness.light,
    primaryColor: primary,
    scaffoldBackgroundColor: background,

    colorScheme: const ColorScheme.light(
      primary: primary,
      secondary: primary,
      surface: background,
    ),


    // AppBar
    appBarTheme: const AppBarTheme(
      backgroundColor: Colors.white,
      foregroundColor: Colors.black,
      elevation: 0,
      centerTitle: true,
    ),


    // Textos
    textTheme: const TextTheme(
      bodyMedium: TextStyle(
        fontSize: 11,
        color: textColor,
        fontWeight: FontWeight.w400,
      ),

      bodySmall: TextStyle(
        fontSize: 11,
        color: textColor,
        fontWeight: FontWeight.w400,
      ),

      headlineSmall: TextStyle(
        fontSize: 28,
        color: textColor,
        fontWeight: FontWeight.w800,
      ),

      titleLarge: TextStyle(
        fontSize: 28,
        color: textColor,
        fontWeight: FontWeight.w800,
      ),
    ),


    // Campos de texto
    inputDecorationTheme: InputDecorationTheme(
      isDense: true,

      contentPadding: const EdgeInsets.symmetric(
        horizontal: 12,
        vertical: 14,
      ),

      hintStyle: const TextStyle(
        fontSize: 11,
        color: hint,
      ),

      floatingLabelBehavior: FloatingLabelBehavior.never,

      enabledBorder: OutlineInputBorder(
        borderRadius: BorderRadius.circular(_radius),
        borderSide: const BorderSide(
          color: borderIdle,
          width: 1,
        ),
      ),

      focusedBorder: OutlineInputBorder(
        borderRadius: BorderRadius.circular(_radius),
        borderSide: const BorderSide(
          color: primary,
          width: 1.5,
        ),
      ),

      border: OutlineInputBorder(
        borderRadius: BorderRadius.circular(_radius),
        borderSide: const BorderSide(
          color: borderIdle,
          width: 1,
        ),
      ),

      errorBorder: OutlineInputBorder(
        borderRadius: BorderRadius.circular(_radius),
        borderSide: const BorderSide(
          color: Colors.redAccent,
          width: 1,
        ),
      ),

      focusedErrorBorder: OutlineInputBorder(
        borderRadius: BorderRadius.circular(_radius),
        borderSide: const BorderSide(
          color: Colors.redAccent,
          width: 1.5,
        ),
      ),
    ),

    


    // Botones
    elevatedButtonTheme: ElevatedButtonThemeData(
      style: ElevatedButton.styleFrom(
        backgroundColor: primary,
        foregroundColor: Colors.white,
        elevation: 0,

        minimumSize: const Size(double.infinity, 46),

        textStyle: const TextStyle(
          fontSize: 12,
          fontWeight: FontWeight.w600,
        ),

        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(_radius),
        ),
      ),
    ),
  );
}
