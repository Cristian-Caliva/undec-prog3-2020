package com.undec.restaurante.controller;
import com.undec.restaurante.model.Restaurante;
import com.undec.restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    //crea un solo restaurante
    @PostMapping("/restaurante")
    public String create(@Valid @RequestBody Restaurante restaurante) {

        return restauranteService.save(restaurante);
    }

    //Actualiza
    /*@PutMapping("/restaurantes/{id}")
    public ResponseEntity<Restaurante> update(@PathVariable(value = "id") Integer restauranteId,
                                              @Valid @RequestBody Restaurante restauranteRestaurante) {
        Restaurante restaurante = restauranteService.findOne(restauranteId);
        if(restaurante == null) {
            return ResponseEntity.notFound().build();
        }
        //restaurante.setId(restauranteRestaurante.getId());
        restaurante.setNombre(restauranteRestaurante.getNombre());
        restaurante.setDescripcion(restauranteRestaurante.getDescripcion());
        restaurante.setDireccion(restauranteRestaurante.getDireccion());
        restaurante.setImagen(restauranteRestaurante.getImagen());
        restaurante.setPrecio(restauranteRestaurante.getPrecio());

        restauranteService.save(restaurante);
        return ResponseEntity.ok(restaurante);
    }*/

    //borra
    /*@DeleteMapping("/restaurantes/{id}")
    public ResponseEntity<Restaurante> delete(@PathVariable(value = "id") Integer restauranteId) {
        Restaurante restaurante = restauranteService.findOne(restauranteId);
        if(restaurante == null) {
            return ResponseEntity.notFound().build();
        }

        restauranteService.delete(restaurante);
        return ResponseEntity.ok().build();
    }

    //Busca los Restaurantes por precio
    @GetMapping("/restaurante/precio/{precio}")
    public List<Restaurante> getRestoByPrecio(@PathVariable(value = "precio") String precio){
        return restauranteService.BuscarRestaurantePrecio(precio);
    }*/

}