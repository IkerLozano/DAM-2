package org.iesch.ad.demoSpringDataMongoProductor.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "productos")
public class Producto {


    @Id
    private String id;
    @Indexed(unique = true)
    private String sku;
    private String nombre;
    private String categoria;
    private Double precio;
    private Integer stock;
    @Builder.Default
    private List<String> etiquetas = new ArrayList<>();
}