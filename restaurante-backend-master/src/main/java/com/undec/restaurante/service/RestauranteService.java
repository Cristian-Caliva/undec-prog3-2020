package com.undec.restaurante.service;
import com.undec.restaurante.model.Restaurante;
import com.undec.restaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    public String delete(Restaurante r) {
        restauranteRepository.delete(r);
        return "Borrado";
    }


    public List<Restaurante> BuscarRestaurantePrecio(String precio){
        return restauranteRepository.findAllByPrecio(precio);
    }
}