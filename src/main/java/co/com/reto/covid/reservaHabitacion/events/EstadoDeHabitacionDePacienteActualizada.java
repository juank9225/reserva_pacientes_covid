package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.registroDePaciente.values.Estado;
import co.com.reto.covid.reservaHabitacion.values.NumeroHabitacion;
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
