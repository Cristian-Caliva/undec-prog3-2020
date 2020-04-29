package com.undec.restaurante.repository;

import com.undec.restaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    @Query("SELECT r FROM Restaurante r WHERE LOWER(r.precio) = LOWER(:precio2)")
    List<Restaurante> findAllByPrecio(@Param("precio2")String precio);
}
