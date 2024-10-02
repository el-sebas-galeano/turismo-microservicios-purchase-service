package com.turismo.purchase_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismo.purchase_microservice.entity.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long>{
    
}
