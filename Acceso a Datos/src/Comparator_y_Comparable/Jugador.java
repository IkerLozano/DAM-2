package Comparator_y_Comparable;

public class Jugador implements Comparable<Jugador> { //La clase Jugador va a implementar la interfaz Comparable en la clase Jugador

    //constructores
    private String nombre;
    private int edad;

    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Jugador() {
    }

    //getter y setter
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }


    //to String
    @Override
    public String toString() {
        return "Comparator_y_Comparable.Jugador{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }


    //------------------
    //COMPARABLE
    //-----------------

        //ordeno por edad
    public int compareTo(Jugador j1){
        return this.edad - j1.getEdad();

        //si queremos de mayor a menor --> otro.getEdad()- this.edad
    }


}



