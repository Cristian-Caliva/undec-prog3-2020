package gestor;

import excepciones.AvionIncompletoException;
import excepciones.AvionNoEncontradoException;
import modelo.Avion;

import java.util.ArrayList;
import java.util.List;

public class GestorDeVuelo {
    public Avion crearAvion(Integer ID, String matricula, String modelo, int capacidad, int anioFabricacion) throws AvionIncompletoException {
        boolean validacion = false;
        Avion avion = Avion.instancia(ID, matricula, modelo, capacidad, anioFabricacion);
        if(avion == null){
            throw new AvionIncompletoException();
        }
        return avion;
    }

    public Avion buscarUnAvion(List<Avion> aviones, Integer IDBuscado, String matriculaBuscada, String modeloBuscado, int capacidadBuscada, int anioFabricacionBuscada) throws AvionNoEncontradoException {
        List<Avion> avionEncontrado = new ArrayList<Avion>();
        for(int i = 0; i < aviones.size(); i++){
            if(aviones.get(i).getID().equals(IDBuscado) || aviones.get(i).getMatricula().equals(matriculaBuscada) || aviones.get(i).getModelo().equals(modeloBuscado) || aviones.get(i).getCapacidad() == capacidadBuscada || aviones.get(i).getAnioFabricacion() == anioFabricacionBuscada){
                avionEncontrado.add(aviones.get(i));
            }
        }
        if(avionEncontrado.size() == 0){
            throw new AvionNoEncontradoException();
        }
        return avionEncontrado.get(0);
    }

    public Avion modificarDatosAvion(Avion avion, Integer IDNuevo, String matriculaNueva, String modeloNuevo, int capacidadNueva, int anioFabricacionNuevo) {
        return avion.modificarDatos(avion, IDNuevo, matriculaNueva, modeloNuevo, capacidadNueva, anioFabricacionNuevo);
    }

    public List<Avion> buscarALLAvion(List<Avion> aviones){
        List<Avion> todosLosAviones = new ArrayList<Avion>();
        todosLosAviones.addAll(aviones);
        return todosLosAviones;
    }
}
