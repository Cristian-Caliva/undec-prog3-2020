package repositorios;

import modelo.Vuelo;

public interface IRepositorioCrearVuelo {
    boolean persist(Vuelo vueloNuevo);
}
