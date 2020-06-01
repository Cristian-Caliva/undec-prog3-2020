package gestor;

import excepciones.AvionIncompletoException;
import excepciones.AvionNoEncontradoException;
import modelo.Avion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GestorAvionUnitTest {
    GestorDeVuelo gestorDeUnVuelo = new GestorDeVuelo();
    List<Avion> aviones = new ArrayList<Avion>();
    List<Avion> buscarAvion = new ArrayList<Avion>();
    @Test
    public void crearAvion_datosCompletos_instanciaCorrecta() throws AvionIncompletoException {
       aviones.add(gestorDeUnVuelo.crearAvion(1,"LX-RTY", "Airbus A330", 189, 2011));
       Assertions.assertNotNull(aviones.get(0));
    }

    @Test
    public void editarAvion_datosCompletos_instanciaCorrecta() throws AvionIncompletoException, AvionNoEncontradoException {
        aviones.add(gestorDeUnVuelo.crearAvion(1,"LX-RTY", "Airbus A330", 189, 2011));
        aviones.add(gestorDeUnVuelo.crearAvion(2,"MI-OLX", "Airbus A330", 145, 2009));
        aviones.add(gestorDeUnVuelo.crearAvion(3,"HD-JJL", "Airbus Z550", 179, 2015));
        buscarAvion.add(gestorDeUnVuelo.buscarUnAvion(aviones, 2, "", "", 0, 0));
        Assertions.assertNotNull(gestorDeUnVuelo.modificarDatosAvion(buscarAvion.get(0), 4,"YY-OOO", "Airbus C001", 200, 2018));
    }

    @Test
    public void consultarAllAviones_datosCompletos_instanciaCorrecta() throws AvionIncompletoException{
        aviones.add(gestorDeUnVuelo.crearAvion(1,"LX-RTY", "Airbus A330", 189, 2011));
        aviones.add(gestorDeUnVuelo.crearAvion(2,"MI-OLX", "Airbus A330", 145, 2009));
        aviones.add(gestorDeUnVuelo.crearAvion(3,"HD-JJL", "Airbus Z550", 179, 2015));
        buscarAvion.addAll(gestorDeUnVuelo.buscarALLAvion(aviones));
        Assertions.assertNotNull(buscarAvion);
    }

    @Test
    public void consultarAvionPorMatricula_datosCompletos_instanciaCorrecta() throws AvionIncompletoException, AvionNoEncontradoException{
        aviones.add(gestorDeUnVuelo.crearAvion(1,"LX-RTY", "Airbus A330", 189, 2011));
        aviones.add(gestorDeUnVuelo.crearAvion(2,"MI-OLX", "Airbus A330", 145, 2009));
        aviones.add(gestorDeUnVuelo.crearAvion(3,"HD-JJL", "Airbus Z550", 179, 2015));
        buscarAvion.add(gestorDeUnVuelo.buscarUnAvion(aviones, null, "MI-OLX", "", 0, 0));
    }
}
