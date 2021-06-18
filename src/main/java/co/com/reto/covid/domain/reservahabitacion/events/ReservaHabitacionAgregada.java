package co.com.reto.covid.domain.reservahabitacion.events;

import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.registrodepaciente.values.Fecha;
import co.com.reto.covid.domain.registrodepaciente.values.Hora;
import co.com.sofka.domain.generic.DomainEvent;

public class ReservaHabitacionAgregada extends DomainEvent {
    private final Fecha fecha;
    private final Hora hora;
    private final Estado estado;

    public ReservaHabitacionAgregada(Fecha fecha, Hora hora, Estado estado) {
        super("sofka.reservahabitacion.reservahabitacionagregada");
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Hora getHora() {
        return hora;
    }

    public Estado getEstado() {
        return estado;
    }
}
