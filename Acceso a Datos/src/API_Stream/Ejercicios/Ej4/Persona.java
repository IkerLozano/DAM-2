package API_Stream.Ejercicios.Ej4;

public class Persona {

    private String Nombre;
    private Integer Edad;

    //constructor
    public Persona(String nombre, Integer edad) {
        Nombre = nombre;
        Edad = edad;
    }

    //getter y setter
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    //toString
    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Edad=" + Edad +
                '}';
    }
}
