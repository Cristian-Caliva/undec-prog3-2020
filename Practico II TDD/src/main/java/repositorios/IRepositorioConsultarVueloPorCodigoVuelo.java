package repositorios;

import modelo.Vuelo;

public interface IRepositorioConsultarVueloPorCodigoVuelo {
    Vuelo findByCodigoVuelo(String codigoVuelo);
}
