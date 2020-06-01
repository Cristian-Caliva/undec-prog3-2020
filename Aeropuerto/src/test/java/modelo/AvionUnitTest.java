package modelo;
import excepciones.AvionIncompletoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AvionUnitTest {
    @Test
    public void crearInstanciaAvion_datosCompletosAvion_instanciaCorrecta() throws AvionIncompletoException {
        Avion avion =  Avion.instancia(1,"LX-RTY", "Airbus A330", 189, 2011);
        Assertions.assertNotNull(avion);
    }

    @Test
    public void crearInstancia_datosIncompletos_arrojaExceptions(){
        Assertions.assertThrows(AvionIncompletoException.class, () -> Avion.instancia(null,"", "", 0, 0));
    }

}
