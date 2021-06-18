package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.registroDePaciente.values.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoDeHabitacionDePacienteActualizada extends DomainEvent {
    private final Estado estado;

    public EstadoDeHabitacionDePacienteActualizada(Estado estado) {
        super("sofka.reservahabitacion.estadodehabitaciodepacienteactualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
