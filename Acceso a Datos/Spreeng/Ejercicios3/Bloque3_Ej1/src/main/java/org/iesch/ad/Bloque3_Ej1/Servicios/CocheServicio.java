package org.iesch.ad.Bloque3_Ej1.Servicios;


import org.iesch.ad.Bloque3_Ej1.DTO.ClienteProyeccion;
import org.iesch.ad.Bloque3_Ej1.Modelo.Cliente;
import org.iesch.ad.Bloque3_Ej1.Modelo.Coche;
import org.iesch.ad.Bloque3_Ej1.Repositorios.ClienteRepo;
import org.iesch.ad.Bloque3_Ej1.Repositorios.CocheRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CocheServicio {


    @Autowired
    CocheRepo cocheRepo;


    @Autowired
    ClienteRepo clienteRepo;

    public List<Cliente> clientesPorColor(String color) {

        return clienteRepo.findByCochesColor(color);

    }

    public List<Cliente> clientesPorPrecioMayorQue(BigDecimal precio) {

        return  clienteRepo.findByCochesPrecioGreaterThan(precio);
    }

    public List<String> clientesConMasCoches() {

        return clienteRepo.clienteConMasCoches();

    }

    public List<Coche> cochesConMenosRevisiones() {

        return cocheRepo.cochesRevisiones();

    }

    public List<String> revisionesPorCoche() {

        return cocheRepo.cocheYmatricula();

    }

    public Optional<Cliente> clientePorMatricula(String matricula) {

        return null;
    }

    public Optional<Cliente> clientePorCodigoRevision(String codigo) {

        return null;

    }

    public Optional<Object> resumenPorCodigoRevision(String codigo) {

        return null;

    }
}
