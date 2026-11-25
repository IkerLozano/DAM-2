package org.iesch.ad.demoSpring1.modelo;


//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Coche {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autonumerico
    Long id;
    String marca;
    String modelo;
    String matricula;



    //indico la relacion uno a uno
    @OneToOne(mappedBy = "coche")// indica que la relación está controlada por el atributo coche de la clase Persona
    @ToString.Exclude //para que el hijo no tenga el toString y que no tenga referencia infinita
    Persona persona; //permite acceder desde un coche hasta la persona relacionada



}
