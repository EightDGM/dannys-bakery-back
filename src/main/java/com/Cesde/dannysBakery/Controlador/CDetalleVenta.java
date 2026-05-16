package com.Cesde.dannysBakery.Controlador;

import com.Cesde.dannysBakery.Modelo.MDetalleVenta;
import com.Cesde.dannysBakery.Servicio.SDetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalleventas")
@CrossOrigin("*")
public class CDetalleVenta {

    @Autowired
    SDetalleVenta sDetalleVenta;

    // GUARDAR
    @PostMapping
    public MDetalleVenta guardar(
            @RequestBody MDetalleVenta detalleVenta
    ) throws Exception {

        return sDetalleVenta.adicionarDetalleVenta(detalleVenta);
    }

    // LISTAR
    @GetMapping
    public List<MDetalleVenta> listar() throws Exception {

        return sDetalleVenta.consultaGeneral();
    }

    // CONSULTAR POR ID
    @GetMapping("/{id}")
    public MDetalleVenta buscarPorId(
            @PathVariable Integer id
    ) throws Exception {

        return sDetalleVenta.consultaPorId(id);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public MDetalleVenta modificar(
            @PathVariable Integer id,
            @RequestBody MDetalleVenta detalleVenta
    ) throws Exception {

        return sDetalleVenta.modificarDetalleVenta(id, detalleVenta);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public Boolean eliminar(
            @PathVariable Integer id
    ) throws Exception {

        return sDetalleVenta.eliminarDetalleVenta(id);
    }
}