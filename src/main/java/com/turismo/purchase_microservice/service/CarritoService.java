package com.turismo.purchase_microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismo.purchase_microservice.entity.Carrito;
import com.turismo.purchase_microservice.repository.CarritoRepository;

@Service
public class CarritoService {
    
    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> obtenerTodosLosCarritos() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> obtenerCarritoPorId(Long id) {
        return carritoRepository.findById(id);
    }

    public Carrito crearCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public Carrito actualizarCarrito(Long id, Carrito detallesCarrito) {
        return carritoRepository.findById(id).map(carritoExistente -> {
            carritoExistente.setPrecioTotal(detallesCarrito.getPrecioTotal());
            carritoExistente.setServicios(detallesCarrito.getServicios());
            carritoExistente.setIdCliente(detallesCarrito.getIdCliente());
            return carritoRepository.save(carritoExistente);
        }).orElseThrow(() -> new RuntimeException("Carrito no encontrado con ID: " + id));
    }

    public void eliminarCarrito(Long id) {
        carritoRepository.deleteById(id);
    }
}
