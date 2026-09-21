package API_Stream.Collectors;

import java.util.List;

public class Jugadores {

    private String nombre;
    private List<String> viajes;
    private int edad;

    //constructor
    public Jugadores(String nombre, int edad, List<String> viajes) {
        this.nombre = nombre;
        this.edad = edad;
        this.viajes = viajes;
    }

    //getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getViajes() {
        return viajes;
    }

    public void setViajes(List<String> viajes) {
        this.viajes = viajes;
    }

    //toString
    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", viajes=" + viajes +
                '}';
    }
}
