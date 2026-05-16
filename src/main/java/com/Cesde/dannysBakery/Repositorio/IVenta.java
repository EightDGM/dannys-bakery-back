package com.Cesde.dannysBakery.Repositorio;

import com.Cesde.dannysBakery.Modelo.MVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVenta extends JpaRepository<MVenta, Integer> {

}