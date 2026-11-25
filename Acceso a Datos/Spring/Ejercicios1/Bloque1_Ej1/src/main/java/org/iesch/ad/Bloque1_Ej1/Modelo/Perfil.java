package org.iesch.ad.Bloque1_Ej1.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String foto;
    String descripcion;
    LocalDate fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")

    Usuario usuario; //este nombre usuario se pobdria en el mapped by para la bidireccionaoidad

}
