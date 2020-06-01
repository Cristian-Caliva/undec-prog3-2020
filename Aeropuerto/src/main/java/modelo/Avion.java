package modelo;

import excepciones.AvionIncompletoException;

public class Avion {
    private Integer ID;
    private String matricula;
    private String modelo;
    private int capacidad;
    private int anioFabricacion;
    
    public Avion(Integer ID, String matricula, String modelo, int capacidad, int anioFabricacion) {
        this.ID = ID;
        this.matricula = matricula;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.anioFabricacion = anioFabricacion;
    }

    public static Avion instancia(Integer ID, String matricula, String modelo, int capacidad, int anioFabricacion) throws AvionIncompletoException {
        boolean matriculaValida = validacionMatricula(matricula);
        if(ID == null || matriculaValida == false || modelo.isEmpty() || capacidad == 0 || anioFabricacion == 0){
            throw new AvionIncompletoException();
        }
        return new Avion(ID, matricula, modelo, capacidad, anioFabricacion);

    }

    public Integer getID() {
        return ID;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public static boolean validacionMatricula(String matricula) {

        return matricula.matches("^([A-Z]{2}[-][A-Z]{3})$");
    }

    public Avion modificarDatos(Avion avion, Integer IDNuevo, String matriculaNueva, String modeloNuevo, int capacidadNueva, int anioFabricacionNuevo) {
        avion.setID(IDNuevo);
        avion.setMatricula(matriculaNueva);
        avion.setModelo(modeloNuevo);
        avion.setCapacidad(capacidadNueva);
        avion.setAnioFabricacion(anioFabricacionNuevo);
        return avion;
    }
}
