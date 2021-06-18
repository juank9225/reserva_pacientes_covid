package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.registroDePaciente.values.Estado;
import co.com.reto.covid.registroDePaciente.values.Fecha;
import co.com.reto.covid.registroDePaciente.values.Hora;
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
