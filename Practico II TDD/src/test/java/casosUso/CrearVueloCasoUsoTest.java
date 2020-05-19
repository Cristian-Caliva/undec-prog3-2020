package casosUso;

import excepciones.VueloIncompletoException;
import modelo.Vuelo;
import org.junit.jupiter.api.Test;

public class CrearVueloCasoUsoTest {
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
        pilotos.add(new Piloto("20-31734609-6", 23456007, "Caliva", "Cristian", fechaNacimiento));
        SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento1=null;
        try {
            Date fechaNacimiento2 = formato1.parse("1984-12-01");
            fechaNacimiento1 = fechaNacimiento2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pilotos.add(new Piloto("30-38906789-8", 89023456, "Quintero", "Juanfer", fechaNacimiento1));

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
        when(iRepositorioCrearVuelo,persist(vueloNuevo)).thenReturn(true);
        when(iRepositorioConsultarVueloPorCodigoVuelo.findByCodigoVuelo("AV 1234")).thenReturn(null);
        CrearVueloCasoUso crearVueloCasoUso = new CrearVueloCasoUso(iRepositorioCrearVuelo, iRepositorioConsultarVueloPorCodigoVuelo);
        Assertions.assertTrue(crearVueloCasoUso.CrearCuenta(vueloNuevo));

    }
}
