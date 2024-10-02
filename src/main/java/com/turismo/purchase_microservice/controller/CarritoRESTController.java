package com.turismo.purchase_microservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.purchase_microservice.entity.Carrito;
import com.turismo.purchase_microservice.service.CarritoService;

@RestController
@RequestMapping(path = "/carrito")
public class CarritoRESTController {
    
        @Autowired
    private CarritoService carritoService;

    @GetMapping
    public ResponseEntity<List<Carrito>> obtenerTodosLosCarritos() {
        List<Carrito> carritos = carritoService.obtenerTodosLosCarritos();
        return new ResponseEntity<>(carritos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> obtenerCarritoPorId(@PathVariable Long id) {
        Optional<Carrito> carrito = carritoService.obtenerCarritoPorId(id);
        return carrito.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito) {
        Carrito nuevoCarrito = carritoService.crearCarrito(carrito);
        return new ResponseEntity<>(nuevoCarrito, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Long id, @RequestBody Carrito carritoDetalles) {
        try {
            Carrito carritoActualizado = carritoService.actualizarCarrito(id, carritoDetalles);
            return new ResponseEntity<>(carritoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long id) {
        carritoService.eliminarCarrito(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
