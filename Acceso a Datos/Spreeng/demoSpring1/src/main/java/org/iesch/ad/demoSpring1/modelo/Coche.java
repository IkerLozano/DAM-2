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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marca;
    String modelo;
    String matricula;

    @OneToOne(mappedBy = "coche")//nombre de la variable que hace el mapeo en la relacion padre
    @ToString.Exclude //para q el hijo no tenga el toString y que no tenga referencia infinita
    Persona persona;



}
