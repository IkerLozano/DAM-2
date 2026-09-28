package API_Stream.Ejercicios.Ej3_part2;

public class Personas {

    private String nombre;
    private int edad;

    //constructores
    public Personas(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
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


    //toString
    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
