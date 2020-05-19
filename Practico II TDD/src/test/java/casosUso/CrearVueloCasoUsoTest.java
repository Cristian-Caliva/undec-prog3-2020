package casosUso;

import excepciones.VueloExisteException;
import excepciones.VueloIncompletoException;
import mockito.MockitoExtension;
import modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorios.IRepositorioConsultarVueloPorCodigoVuelo;
import repositorios.IRepositorioCrearVuelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearVueloCasoUsoTest {
    @Mock
    IRepositorioCrearVuelo iRepositorioCrearVuelo;

    @Mock
    IRepositorioConsultarVueloPorCodigoVuelo iRepositorioConsultarVueloPorCodigoVuelo;


    @Test
    public void crearVuelo_vueloNoExiste_crearVueloCorrectamente() throws VueloIncompletoException, VueloExisteException {
        LocalDateTime fechaHoraSalida = LocalDateTime.of(2020, 6, 15, 18, 30);
        LocalDateTime fechaHoraLlegada = LocalDateTime.of(2020, 6, 15, 22, 00);
        Aeropuerto aeropuertoSalida = new Aeropuerto("EZE", "Pajas Blancas", "Cordoba", 5000);
        Aeropuerto aeropuertoLlegada = new Aeropuerto("JXO", "Capitán Vicente Almonacid", "La Rioja", 5360);
        Avion avion = new Avion("LV-FNI", "Airbus A330", 189, 2011);
        List<Piloto> pilotos = new ArrayList<Piloto>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento=null;
        try {
            Date fechaNacimiento1 = formato.parse("1984-12-01");
            fechaNacimiento = fechaNacimiento1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pilotos.add(new Piloto("20-39509798-8", 00000456, "Armani", "Franco", fechaNacimiento));
        SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento1=null;
        try {
            Date fechaNacimiento2 = formato1.parse("1984-12-01");
            fechaNacimiento1 = fechaNacimiento2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pilotos.add(new Piloto("30-43980067-7", 11118790, "Martinez", "Pity", fechaNacimiento1));

        SimpleDateFormat formato3 = new SimpleDateFormat("yyyy");
        Date fechaInicio = null;
        try {
            Date fechaInicio1 = formato3.parse("1927");
            fechaInicio = fechaInicio1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Aerolinea aerolinea = new Aerolinea("30-64140555-4", "AV", "Aerolineas Argentinas", fechaInicio);
        Vuelo vueloNuevo = Vuelo.instancia("AV 1234", fechaHoraSalida, fechaHoraLlegada, aeropuertoSalida, aeropuertoLlegada, avion, pilotos, aerolinea);
        when(iRepositorioCrearVuelo.persist(vueloNuevo)).thenReturn(true);
        when(iRepositorioConsultarVueloPorCodigoVuelo.findByCodigoVuelo("AV 1234")).thenReturn(null);
        CrearVueloCasoUso crearVueloCasoUso = new CrearVueloCasoUso(iRepositorioCrearVuelo, iRepositorioConsultarVueloPorCodigoVuelo);
        Assertions.assertTrue(crearVueloCasoUso.CrearVuelo(vueloNuevo));

    }
}
