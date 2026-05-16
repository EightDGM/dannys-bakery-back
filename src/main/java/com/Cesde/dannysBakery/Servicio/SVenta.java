package com.Cesde.dannysBakery.Servicio;

import com.Cesde.dannysBakery.Modelo.MVenta;
import com.Cesde.dannysBakery.Repositorio.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SVenta {

    @Autowired
    IVenta iVenta;

    // GUARDAR
    public MVenta adicionarVenta(MVenta venta) throws Exception {

        try {

            return iVenta.save(venta);

        } catch (Exception e) {

            throw new Exception("Error al guardar venta");
        }
    }

    // LISTAR
    public List<MVenta> consultaGeneral() throws Exception {

        try {

            return iVenta.findAll();

        } catch (Exception e) {

            throw new Exception("Error al listar ventas");
        }
    }

    // CONSULTAR POR ID
    public MVenta consultaPorId(Integer id) throws Exception {

        try {

            Optional<MVenta> encontrado = iVenta.findById(id);

            if(encontrado.isPresent()){

                return encontrado.get();

            }else{

                throw new Exception("Venta no encontrada");
            }

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // MODIFICAR
    public MVenta modificarVenta(Integer id, MVenta venta) throws Exception {

        try {

            Optional<MVenta> encontrado = iVenta.findById(id);

            if(encontrado.isPresent()){

                MVenta nuevo = encontrado.get();

                nuevo.setVenFecha(venta.getVenFecha());
                nuevo.setVenTotal(venta.getVenTotal());
                nuevo.setUsuario(venta.getUsuario());
                nuevo.setEmpleado(venta.getEmpleado());

                return iVenta.save(nuevo);

            }else{

                throw new Exception("Venta no encontrada");
            }

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // ELIMINAR
    public Boolean eliminarVenta(Integer id) throws Exception {

        try {

            Optional<MVenta> encontrado = iVenta.findById(id);

            if(encontrado.isPresent()){

                iVenta.deleteById(id);

                return true;

            }else{

                throw new Exception("Venta no encontrada");
            }

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}