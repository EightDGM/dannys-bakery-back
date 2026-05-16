package com.Cesde.dannysBakery.Repositorio;

import com.Cesde.dannysBakery.Modelo.MDetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleVenta extends JpaRepository<MDetalleVenta, Integer> {

}