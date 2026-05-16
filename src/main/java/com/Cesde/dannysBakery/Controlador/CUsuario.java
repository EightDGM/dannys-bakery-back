package com.Cesde.dannysBakery.Controlador;

import com.Cesde.dannysBakery.Modelo.MUsuario;
import com.Cesde.dannysBakery.Servicio.SUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class CUsuario {

    @Autowired
    SUsuario sUsuario;

    // GUARDAR
    @PostMapping
    public MUsuario guardar(@RequestBody MUsuario usuario) throws Exception {
        return sUsuario.adicionarUsuario(usuario);
    }

    // LISTAR
    @GetMapping
    public List<MUsuario> listar() throws Exception {
        return sUsuario.consultaGeneral();
    }

    // CONSULTAR POR ID
    @GetMapping("/{id}")
    public MUsuario buscarPorId(@PathVariable Integer id) throws Exception {
        return sUsuario.consultaPorId(id);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public MUsuario modificar(
            @PathVariable Integer id,
            @RequestBody MUsuario usuario
    ) throws Exception {

        return sUsuario.modificarUsuario(id, usuario);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public Boolean eliminar(@PathVariable Integer id) throws Exception {
        return sUsuario.eliminarUsuario(id);
    }
}