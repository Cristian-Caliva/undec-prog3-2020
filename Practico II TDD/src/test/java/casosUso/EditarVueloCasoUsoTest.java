package casosUso;

import org.junit.jupiter.api.Test;
import repositorios.IRepositorioConsultarVueloPorCodigoVuelo;

public class EditarVueloCasoUsoTest {

    @Mock
    IRepositorioEditarVuelo iRepositorioEditarVuelo;

    @Mock
    IRepositorioConsultarVueloPorCodigoVuelo iRepositorioConsultarVueloPorCodigoVuelo;


    @Test
    public void editarCuenta_DatosCorrectos_DevuelveCuentaModificada(){
        LocalDateTime fechaHoraSalida = LocalDateTime.of(2020, 6, 15, 18, 30);
        LocalDateTime fechaHoraLlegada = LocalDateTime.of(2020, 6, 15, 22, 00);
        Vuelo vueloViejoModificar = Vuelo.instancia("AV 1234", fechaHoraSalida, fechaHoraLlegada, aeropuertoSalida, aeropuertoLlegada, avion, pilotos, aerolinea);

        LocalDateTime fechaHoraSalidaActualizada = LocalDateTime.of(2020, 6, 20, 10, 30);
        LocalDateTime fechaHoraLlegadaActualizada = LocalDateTime.of(2020, 6, 20, 14, 00);
        Vuelo vueloNuevosDatos = Vuelo.instancia("AV 1234", fechaHoraSalidaActualizada, fechaHoraLlegadaActualizada, aeropuertoSalida, aeropuertoLlegada, avion, pilotos, aerolinea);

        when(iRepositorioConsultarVueloPorCodigoVuelo.findByCodigoVuelo("AV 1234")).thenReturn(vueloViejoModificar);
        when(iRepositorioEditarVuelo.update(vueloViejoModificar)).thenReturn(true);

        EditarVueloCasoUso editarVueloCasoUso = new EditarVueloCasoUso(iRepositorioEditarVuelo,iRepositorioConsultarVueloPorCodigoVuelo);

        Vuelo vuelo = editarVueloCasoUso.EditarVuelo(vueloNuevosDatos);
        Assertions.assertEquals(fechaHoraSalidaActualizada,vuelo.getFechaHoraSalida());
        Assertions.assertEquals(fechaHoraLlegadaActualizada,vuelo.getFechaHoraLlegada());
        //Assertions.assertEquals("Martin Paez Yañez",cuenta.getNombre());

    }
}
