package casosUso;

import inputs.BuscarVueloXFechaInput;
import modelo.Vuelo;
import repositorios.IRepositorioConsultarVueloPorFecha;

import java.time.LocalDateTime;
import java.util.List;

public class BuscarVueloXFechaCasoUso implements BuscarVueloXFechaInput {
    private IRepositorioConsultarVueloPorFecha iRepositorioConsultarVueloPorFecha;
    public BuscarVueloXFechaCasoUso(IRepositorioConsultarVueloPorFecha iRepositorioConsultarVueloPorFecha) {
        this.iRepositorioConsultarVueloPorFecha = iRepositorioConsultarVueloPorFecha;
    }


    public LocalDateTime ConsultarVueloPorFecha(LocalDateTime fechaHoraSalida) {
        List<Vuelo> listaVuelos = (List<Vuelo>) this.iRepositorioConsultarVueloPorFecha.findByVueloPorFecha(fechaHoraSalida);
        int cont = 0;
        for(int i=0; i < listaVuelos.size(); i++){
            if(fechaHoraSalida.equals(listaVuelos.get(i).getFechaHoraSalida())){
                cont++;
            }
        }
        return listaVuelos.get(cont - 1).getFechaHoraSalida();

    }
}
