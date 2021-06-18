package co.com.reto.covid.domain.reservahabitacion.events;

import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroHabitacion;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoDeHabitacionDePacienteActualizada extends DomainEvent {
    private final Estado estado;
    private final NumeroHabitacion numeroHabitacion;

    public EstadoDeHabitacionDePacienteActualizada(NumeroHabitacion numeroHabitacion, Estado estado) {
        super("sofka.reservahabitacion.estadodehabitaciodepacienteactualizado");
        this.estado = estado;
        this.numeroHabitacion = numeroHabitacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public NumeroHabitacion getNumeroHabitacion() {
        return numeroHabitacion;
    }
}
