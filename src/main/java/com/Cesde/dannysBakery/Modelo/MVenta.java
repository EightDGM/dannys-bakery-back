package com.Cesde.dannysBakery.Modelo;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "venta")
public class MVenta {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ven_codigo")
    private Integer venCodigo;

    @Column(name = "ven_fecha", nullable = false)
    private LocalDate venFecha;

    @Column(name = "ven_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal venTotal;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "usu_codigo", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MUsuario usuario;

    @ManyToOne
    @JoinColumn(name = "emp_codigo", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MEmpleado empleado;

    // Constructores
    public MVenta() {}

    public MVenta(LocalDate venFecha, BigDecimal venTotal, MUsuario usuario, MEmpleado empleado) {
        this.venFecha = venFecha;
        this.venTotal = venTotal;
        this.usuario = usuario;
        this.empleado = empleado;
    }

    // Getters y Setters
    public Integer getVenCodigo() { return venCodigo; }
    public void setVenCodigo(Integer venCodigo) { this.venCodigo = venCodigo; }

    public LocalDate getVenFecha() { return venFecha; }
    public void setVenFecha(LocalDate venFecha) { this.venFecha = venFecha; }

    public BigDecimal getVenTotal() { return venTotal; }
    public void setVenTotal(BigDecimal venTotal) { this.venTotal = venTotal; }

    public MUsuario getUsuario() { return usuario; }
    public void setUsuario(MUsuario usuario) { this.usuario = usuario; }

    public MEmpleado getEmpleado() { return empleado; }
    public void setEmpleado(MEmpleado empleado) { this.empleado = empleado; }
}