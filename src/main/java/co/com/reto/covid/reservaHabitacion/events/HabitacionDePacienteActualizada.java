package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.registroDePaciente.values.Estado;
import co.com.reto.covid.reservaHabitacion.values.CantidadCama;
import co.com.sofka.domain.generic.DomainEvent;

public class HabitacionDePacienteActualizada extends DomainEvent {
    private final Estado estado;
    private final CantidadCama cantidadCama;
    public HabitacionDePacienteActualizada(Estado estado, CantidadCama cantidadCama) {
        super("sofka.reservahabitacion.habitaciondepacienteactualizada");
        this.estado = estado;
        this.cantidadCama = cantidadCama;
    }

    public Estado getEstado() {
        return estado;
    }

    public CantidadCama getCantidadCama() {
        return cantidadCama;
    }
}
