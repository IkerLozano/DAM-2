package Comparator_y_Comparable.Ejercicios;

import java.time.LocalDateTime;

public class Paciente {

    private String nombre;
    private int gravedad;
    private LocalDateTime llegada;

    //constructores
    public Paciente(String nombre, int gravedad, LocalDateTime llegada) {
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.llegada = llegada;
    }

    //getter
    public String getNombre() {
        return nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    public LocalDateTime getLlegada() {
        return llegada;
    }

    //toString
    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", gravedad=" + gravedad +
                ", llegada=" + llegada +
                '}';
    }
}
