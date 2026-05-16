package com.Cesde.dannysBakery.Controlador;

import com.Cesde.dannysBakery.Modelo.MVenta;
import com.Cesde.dannysBakery.Servicio.SVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin("*")
public class CVenta {

    @Autowired
    SVenta sVenta;

    // GUARDAR
    @PostMapping
    public MVenta guardar(@RequestBody MVenta venta) throws Exception {

        return sVenta.adicionarVenta(venta);
    }

    // LISTAR
    @GetMapping
    public List<MVenta> listar() throws Exception {

        return sVenta.consultaGeneral();
    }

    // CONSULTAR POR ID
    @GetMapping("/{id}")
    public MVenta buscarPorId(@PathVariable Integer id) throws Exception {

        return sVenta.consultaPorId(id);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public MVenta modificar(
            @PathVariable Integer id,
            @RequestBody MVenta venta
    ) throws Exception {

        return sVenta.modificarVenta(id, venta);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public Boolean eliminar(@PathVariable Integer id) throws Exception {

        return sVenta.eliminarVenta(id);
    }
}