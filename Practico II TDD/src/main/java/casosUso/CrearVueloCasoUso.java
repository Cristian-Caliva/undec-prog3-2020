package casosUso;

import excepciones.VueloExisteException;
import inputs.CrearVueloInput;
import modelo.Vuelo;
import repositorios.IRepositorioConsultarVueloPorCodigoVuelo;
import repositorios.IRepositorioCrearVuelo;

public class CrearVueloCasoUso implements CrearVueloInput {
    private IRepositorioCrearVuelo iRepositorioCrearVuelo;
    private IRepositorioConsultarVueloPorCodigoVuelo iRepositorioConsultarVueloPorCodigoVuelo;
    public CrearVueloCasoUso(IRepositorioCrearVuelo iRepositorioCrearVuelo, IRepositorioConsultarVueloPorCodigoVuelo iRepositorioConsultarVueloPorCodigoVuelo) {
        this.iRepositorioCrearVuelo = iRepositorioCrearVuelo;
        this.iRepositorioConsultarVueloPorCodigoVuelo = iRepositorioConsultarVueloPorCodigoVuelo;
    }

    @Override
    public boolean CrearVuelo(Vuelo vuelo) throws VueloExisteException {
        if(ExisteVuelo(vuelo.getCodigoVuelo())){
            throw new VueloExisteException();
        }

        return iRepositorioCrearVuelo.persist(vuelo);
    }

    private boolean ExisteVuelo(String codigoVuelo) {
        if(this.iRepositorioConsultarVueloPorCodigoVuelo.findByCodigoVuelo(codigoVuelo) != null){
            return true;
        }
        return false;
    }
}
