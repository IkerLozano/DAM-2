package org.iesch.ad.demoSpringDataMongoProductor.Repositorio;

import org.iesch.ad.demoSpringDataMongoProductor.modelos.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {
}