package com.Cesde.dannysBakery.Controlador;

import com.Cesde.dannysBakery.Modelo.MEmpleado;
import com.Cesde.dannysBakery.Servicio.SEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@CrossOrigin("*")
public class CEmpleado {

    @Autowired
    SEmpleado sEmpleado;

    // GUARDAR
    @PostMapping
    public MEmpleado guardar(@RequestBody MEmpleado empleado) throws Exception {

        return sEmpleado.adicionarEmpleado(empleado);
    }

    // LISTAR
    @GetMapping
    public List<MEmpleado> listar() throws Exception {

        return sEmpleado.consultaGeneral();
    }

    // CONSULTAR POR ID
    @GetMapping("/{id}")
    public MEmpleado buscarPorId(@PathVariable Integer id) throws Exception {

        return sEmpleado.consultaPorId(id);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public MEmpleado modificar(
            @PathVariable Integer id,
            @RequestBody MEmpleado empleado
    ) throws Exception {

        return sEmpleado.modificarEmpleado(id, empleado);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public Boolean eliminar(@PathVariable Integer id) throws Exception {

        return sEmpleado.eliminarEmpleado(id);
    }
}