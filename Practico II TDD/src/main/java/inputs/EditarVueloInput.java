package inputs;

import excepciones.ActualizarVueloException;
import excepciones.VueloIncompletoException;
import modelo.Vuelo;

public interface EditarVueloInput {
    Vuelo EditarVuelo(Vuelo vueloNuevosDatos) throws VueloIncompletoException, ActualizarVueloException;
}
