package Colecciones.Ejercicios.Map;

public class Estudiantes {

    private String nombre;
    private Integer edad;
    private String estudios;

    //constructores
    public Estudiantes(String nombre, Integer edad, String estudios) {
        this.nombre = nombre;
        this.edad = edad;
        this.estudios = estudios;
    }

    //getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    //toString
    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", estudios='" + estudios + '\'' +
                '}';
    }
}
