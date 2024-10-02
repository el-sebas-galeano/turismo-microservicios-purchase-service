package com.turismo.purchase_microservice.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "carrito")
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float precioTotal;
    private List<Long> servicios;
    private Long idCliente;
    
    public Carrito() {
    }

    public Carrito(Float precioTotal, List<Long> servicios, Long idCliente) {
        this.precioTotal = precioTotal;
        this.servicios = servicios;
        this.idCliente = idCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<Long> getServicios() {
        return servicios;
    }

    public void setServicios(List<Long> servicios) {
        this.servicios = servicios;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
