package Tema1.PrcaticaEvaluable.Ej1;

public class GestorDescargas {


    private int descargasCompletadas;


    //constructor
    public GestorDescargas() {
        this.descargasCompletadas = descargasCompletadas;
    }


    //getter y setter
    public int getDescargasCompletadas() {
        return descargasCompletadas;
    }


    public void setDescargasCompletadas(int descargasCompletadas) {
        this.descargasCompletadas = descargasCompletadas;
    }

    //Registrar descargas
    public synchronized void registrarDescarga(String nombreArchivo){
        descargasCompletadas++;
        System.out.println(Thread.currentThread().getName());
        System.out.println("La descraga se a completado --> " + nombreArchivo);
        System.out.println("Total: " + descargasCompletadas);

    }


    //descargas completadas
     public void descargasCompletada(){

         System.out.println("Descragas totales: " + descargasCompletadas);


     }

}
