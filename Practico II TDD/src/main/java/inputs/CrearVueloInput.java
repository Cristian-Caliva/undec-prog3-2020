package inputs;

import excepciones.VueloExisteException;
import modelo.Vuelo;

public interface CrearVueloInput {
    boolean CrearVuelo(Vuelo vuelo) throws VueloExisteException;
}
