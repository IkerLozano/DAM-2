package org.iesch.ad.demoSpring1.modelo;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.web.JsonPath;

import java.time.LocalDateTime;


@Getter //genera los getters
@Setter //genera los setters
@ToString //genera el toString
@EqualsAndHashCode
@Builder //Permite crear objetos de forma rapida, encadenando campos
@AllArgsConstructor //Genera un constructor con todos los campos, en el orden en que están declarados
@NoArgsConstructor //Genera un constructor vacío
@Entity //crea una tabla en bbdd con el nombre perosna y los atributos

public class Persona {


    @Id //inidca el id para ls bbdd
            @GeneratedValue(strategy = GenerationType.IDENTITY) //autonumerico
    Long id;
    //@Column() para indicarle la configuracion del dato(unique...)
    String nombre;
    String apellidos;
    @Column(length = 9) //longutus de la columna
    String dni;
    String email;
    private LocalDateTime createdAt;



    //mostar la fecha de cuando creo una persona
    @PrePersist //indica que este metodo se ejecuta justo antes de insertar una nueva persona en la base de datos
    public void preGuardar(){
        this.createdAt = LocalDateTime.now();
    }


    //mostrar por consola el ID que se ha generado al guardar la persona
    @PostPersist//indica que este metodo se ejecuta después de insertar una nueva persona en la base de datos
    public void postGuardado(){

        System.out.println("Se guarda con id: " + this.id);
        //no tenemos que llamar a este metodo nostros, Hibernate lo ejecuta automáticamente
    }



    //índico la relación uno a uno
        //Una persona tiene un coche.
        //Un coche pertenece a una persona.
    @OneToOne(cascade = CascadeType.ALL) //lo que hagamos en persona se propaga en coche
    @JoinColumn(name = "coche_id", referencedColumnName = "id") //indica dnd esta la clave ajena, ledigo que la CA se llame "coche_id"
            Coche coche;
            /*
                Es el atributo que permite que una persona tenga asociado un coche,
                asi podemos acceder al coche de esa persona
             */




}
