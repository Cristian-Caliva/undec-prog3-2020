package inputs;

import java.time.LocalDateTime;

public interface BuscarVueloXFechaInput {
    LocalDateTime ConsultarVueloPorFecha(LocalDateTime fecha);
}
