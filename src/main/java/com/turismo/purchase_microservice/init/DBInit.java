package com.turismo.purchase_microservice.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.turismo.purchase_microservice.entity.Carrito;
import com.turismo.purchase_microservice.repository.CarritoRepository;

@Component
public class DBInit implements CommandLineRunner {

    private final CarritoRepository carritoRepository;

    public DBInit(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear 10 carritos aleatorios
        for (int i = 0; i < 10; i++) {
            Carrito carrito = generarCarritoAleatorio();
            carritoRepository.save(carrito);
        }
    }

    // Método separado para generar un carrito aleatorio
    private Carrito generarCarritoAleatorio() {
        Random random = new Random();
        
        // Generar un número aleatorio de servicios entre 1 y 4
        List<Long> servicios = new ArrayList<>();
        int numeroDeServicios = random.nextInt(4) + 1; // Genera entre 1 y 4 servicios
        
        for (int j = 0; j < numeroDeServicios; j++) {
            servicios.add((long) (random.nextInt(4) + 1)); // Servicios con ID del 1 al 4
        }

        // Generar un cliente con ID entre 1 y 5
        Long idCliente = (long) (random.nextInt(5) + 1);

        // Generar un precio total aleatorio
        Float precioTotal = 50.0f + random.nextFloat() * (300.0f - 50.0f); // Precio entre 50 y 300

        // Crear y devolver el carrito
        return new Carrito(precioTotal, servicios, idCliente);
    }
}

