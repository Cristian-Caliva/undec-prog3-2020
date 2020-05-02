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

    //Busca los Restaurantes por precio
    @GetMapping("/restaurante/precio/{precio}")
    public List<Restaurante> getRestoByPrecio(@PathVariable(value = "precio") String precio){
        return restauranteService.BuscarRestaurantePrecio(precio);
    }

}