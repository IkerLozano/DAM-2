package Comparator_y_Comparable.Ejercicios;

import java.util.Comparator;

public class ComparadorGravedad implements Comparator<Paciente> {


    @Override
    public int compare(Paciente p1, Paciente p2) {

        int resultado =  p2.getGravedad() - p1.getGravedad();

        if (resultado == 0){
            resultado = p1.getLlegada().compareTo(p2.getLlegada());
        }

        return resultado;
    }

    /*
    En caso de que la compracion de gravedad sea igual (0) comparara con la hora de llegada
     */
}
