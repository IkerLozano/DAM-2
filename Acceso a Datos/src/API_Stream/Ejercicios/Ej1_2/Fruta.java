package API_Stream.Ejercicios.Ej1_2;

public class Fruta {

      private String Nombre;
      private String Color;


      //constructores
    public Fruta(String nombre, String color) {
        Nombre = nombre;
        Color = color;
    }

    //getter y setter
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }


    //toString
    @Override
    public String toString() {
        return "Fruta{" +
                "Nombre='" + Nombre + '\'' +
                ", Color='" + Color + '\'' +
                '}';
    }
}
