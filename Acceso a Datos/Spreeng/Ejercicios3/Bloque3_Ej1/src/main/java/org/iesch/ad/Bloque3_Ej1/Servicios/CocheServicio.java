package org.iesch.ad.Bloque3_Ej1.Servicios;


import org.iesch.ad.Bloque3_Ej1.Modelo.Cliente;
import org.iesch.ad.Bloque3_Ej1.Modelo.Coche;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CocheServicio {


    public List<Cliente> clientesPorColor(String color) {

        return null;

    }

    public List<Cliente> clientesPorPrecioMayorQue(BigDecimal precio) {

        return  null;
    }

    public List<Cliente> clientesConMasCoches() {

        return  null;

    }

    public List<Coche> cochesConMenosRevisiones() {

        return null;

    }

    public List<Coche> revisionesPorCoche() {

        return null;

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
