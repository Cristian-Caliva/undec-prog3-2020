package repositorios;

import modelo.Vuelo;

import java.time.LocalDateTime;
import java.util.Collection;

public interface IRepositorioConsultarVueloPorFecha {

    Collection<Vuelo> findByVueloPorFecha(LocalDateTime fechaHoraSalida);
}
