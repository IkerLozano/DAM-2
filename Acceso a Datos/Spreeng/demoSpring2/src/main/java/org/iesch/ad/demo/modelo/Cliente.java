package org.iesch.ad.demo.modelo;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data //como si ponemos @gette, @setter, toString(), equals() y hashCode()
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        /*
            fetch = FetchType.EAGER --> indica que cuando recuperamos un cliente, Hibernate carga también sus pedidos
            EAGER: carga los datos relacionados inmediatamente.
            LAZY: carga los datos relacionados cuando los necesitamos.
         */
    @JoinColumn(name = "cliente_id")
    /*
        Sirve para indicar que la relación se va a establecer mediante una columna
        llamada cliente_id en la tabla pedido, de esta manera no nos creara una tabla intermedia

        Como el JoinColumn esta en eta clase, inidcamos que es la clase padre, y por eso
        la columna "cliente_id" esta en la clase pedido
     */

    private List<Pedido> pedidos;


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
    /*
        Se podria poner el ToStrting.Exclude pero no incluya los pedidos cuando
        genere el toString() de Cliente, al imprimir un cliente verás su id y su nombre,
        pero no sus pedido

        De esta manera si que los veremos
     */
}
