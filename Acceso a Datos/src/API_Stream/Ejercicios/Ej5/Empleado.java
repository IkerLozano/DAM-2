package API_Stream.Ejercicios.Ej5;

public class Empleado {

    private String Nombre;
    private String Departamento;

    //constructores
    public Empleado(String nombre, String departamento) {
        Nombre = nombre;
        Departamento = departamento;
    }


    //getter y setter
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    //toString
    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre='" + Nombre + '\'' +
                ", Departamento='" + Departamento + '\'' +
                '}';
    }
}
