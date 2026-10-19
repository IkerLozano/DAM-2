package TEMA_1.API_Stream.Ejercicios.PackEjerciciosExamenStreams.Ej8;
import java.util.Objects;

public class Cancion {

    private String titulo;
    private String cantante;


    //constructores
    public Cancion(String titulo, String cantante) {
        this.titulo = titulo;
        this.cantante = cantante;
    }


    //getter y setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }


    //toString
    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", cantante='" + cantante + '\'' +
                '}';
    }


    //esto es para lo del distinct()
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return Objects.equals(titulo, cancion.titulo) && Objects.equals(cantante, cancion.cantante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, cantante);
    }
}
