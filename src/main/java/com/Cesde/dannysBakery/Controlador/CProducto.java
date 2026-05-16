package com.Cesde.dannysBakery.Controlador;

import com.Cesde.dannysBakery.Modelo.MProducto;
import com.Cesde.dannysBakery.Servicio.SProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class CProducto {

    @Autowired
    SProducto sProducto;

    // GUARDAR
    @PostMapping
    public MProducto guardar(@RequestBody MProducto producto) throws Exception {

        return sProducto.adicionarProducto(producto);
    }

    // LISTAR
    @GetMapping
    public List<MProducto> listar() throws Exception {

        return sProducto.consultaGeneral();
    }

    // CONSULTAR POR ID
    @GetMapping("/{id}")
    public MProducto buscarPorId(@PathVariable Integer id) throws Exception {

        return sProducto.consultaPorId(id);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public MProducto modificar(
            @PathVariable Integer id,
            @RequestBody MProducto producto
    ) throws Exception {

        return sProducto.modificarProducto(id, producto);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public Boolean eliminar(@PathVariable Integer id) throws Exception {

        return sProducto.eliminarProducto(id);
    }
}