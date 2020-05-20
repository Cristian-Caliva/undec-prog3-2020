package casosUso;


import excepciones.VueloIncompletoException;
import modelo.Vuelo;

@ExtendWith(MockitoExtension.class)
public class BuscarVueloXFechaCasoUsoTest {
    @Mock
    IRepositorioConsultarVueloPorFecha iRepositorioConsultarVueloPorFecha;

    @Test
    public void buscarVuelo_vueloExiste_devuelveVuelo{
        List<Vuelo> vuelo = new ArraList<Vuelo>();
        try {
            vuelo.add(Vuelo.instancia("AV 1234", fechaHoraSalida, fechaHoraLlegada, aeropuertoSalida, aeropuertoLlegada, avion, pilotos, aerolinea));
            //Vuelo.add(Vuelo.instancia("FP 7532", fechaHoraSalidaActualizada, fechaHoraLlegadaActualizada, aeropuertoSalida, aeropuertoLlegada, avionActualizado, pilotosUpdates, aerolinea));
        }catch (VueloIncompletoException e){
            e.printStackTrace();
        }

        when(iRepositorioConsultarVueloPorFecha.findAll()).thenReturn(vuelo);
        BuscarVueloXFechaCasoUso buscarVueloXFechaCasoUso = new BuscarVueloXFechaCasoUso(iRepositorioConsultarVueloPorFecha);

        List<Vuelo> vuelosConsultado = (List<Vuelo>) buscarVueloXFechaCasoUso.ConsultarVuelo();
        Assertions.assertEquals(fechaHoraSalida,vuelosConsultado.getFechaHoraSalida());
    }

}
