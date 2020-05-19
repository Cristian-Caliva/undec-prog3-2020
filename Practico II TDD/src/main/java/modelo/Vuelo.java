package modelo;

import excepciones.VueloIncompletoException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String codigoVuelo;
    private LocalDateTime fechaHoraSalida;
    private LocalDateTime fechaHoraLlegada;
    private Aeropuerto aeropuertoSalida;
    private Aeropuerto aeropuertoLlegada;
    private Avion avion;
    private List<Piloto> pilotos = new ArrayList<Piloto>();
    private Aerolinea aerolinea;

    private Vuelo(String codigoVuelo, LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada, Avion avion, List<Piloto> pilotos, Aerolinea aerolinea) {
        this.codigoVuelo = codigoVuelo;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.aeropuertoSalida = aeropuertoSalida;
        this.aeropuertoLlegada = aeropuertoLlegada;
        this.avion = avion;
        this.pilotos = new ArrayList<Piloto>();
        this.pilotos = pilotos;
        this.aerolinea = aerolinea;
    }

    public static Vuelo instancia(String codigoVuelo, LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada, Avion avion, List<Piloto> pilotos, Aerolinea aerolinea) throws VueloIncompletoException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fecHoraSalida = fechaHoraSalida.format(formatter);
        String fecHoraLlegada = fechaHoraLlegada.format(formatter);
        int cantPilotos = pilotos.size();
        if(codigoVuelo.isEmpty()||fecHoraSalida.isEmpty()||fecHoraLlegada.isEmpty()||aeropuertoSalida.equals(null)||aeropuertoLlegada.equals(null)||avion.equals(null)||cantPilotos < 2|| aerolinea.equals(null)){
            throw new VueloIncompletoException();
        }
        return new Vuelo(codigoVuelo, fechaHoraSalida, fechaHoraLlegada, aeropuertoSalida, aeropuertoLlegada, avion, pilotos, aerolinea);
    }

    public String getCodigoVuelo() {return codigoVuelo;}

    public LocalDateTime getFechaHoraSalida() {return fechaHoraSalida;}

    public LocalDateTime getFechaHoraLlegada() {return fechaHoraLlegada;}

    public Aeropuerto getAeropuertoSalida() {return aeropuertoSalida;}

    public Aeropuerto getAeropuertoLlegada() {return aeropuertoLlegada;}

    public Avion getAvion() {return avion;}

    public List<Piloto> getPilotos() {return pilotos;}

    public Aerolinea getAerolinea() {return aerolinea;}
}
