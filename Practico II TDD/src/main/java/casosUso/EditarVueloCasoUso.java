package casosUso;

import excepciones.ActualizarVueloException;
import excepciones.VueloIncompletoException;
import inputs.EditarVueloInput;
import modelo.Vuelo;
import repositorios.IRepositorioConsultarVueloPorCodigoVuelo;
import repositorios.IRepositorioEditarVuelo;

public class EditarVueloCasoUso implements EditarVueloInput {

    private IRepositorioEditarVuelo iRepositorioEditarVuelo;
    private IRepositorioConsultarVueloPorCodigoVuelo iRepositorioConsultarVueloPorCodigoVuelo;

    public EditarVueloCasoUso(IRepositorioEditarVuelo iRepositorioEditarVuelo, IRepositorioConsultarVueloPorCodigoVuelo iRepositorioConsultarVueloPorCodigoVuelo) {
        this.iRepositorioEditarVuelo = iRepositorioEditarVuelo;
        this.iRepositorioConsultarVueloPorCodigoVuelo = iRepositorioConsultarVueloPorCodigoVuelo;
    }

    @Override
    public Vuelo EditarVuelo(Vuelo vueloNuevosDatos) throws VueloIncompletoException, ActualizarVueloException {
        Vuelo modificarVuelo = iRepositorioConsultarVueloPorCodigoVuelo.findByCodigoVuelo(vueloNuevosDatos.getCodigoVuelo());
        modificarVuelo.modificarDatos(vueloNuevosDatos);

        if(iRepositorioEditarVuelo.update(modificarVuelo)){
            return modificarVuelo;
        }else{
            throw new ActualizarVueloException();
        }

    }
}
