package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.registroDePaciente.values.Estado;
import co.com.reto.covid.reservaHabitacion.values.CantidadCama;
import co.com.reto.covid.reservaHabitacion.values.NumeroHabitacion;
import co.com.sofka.domain.generic.DomainEvent;

public class HabitacionDePacienteActualizada extends DomainEvent {
    private final Estado estado;
    private final CantidadCama cantidadCama;
    private final NumeroHabitacion numeroHabitacion;
    public HabitacionDePacienteActualizada(NumeroHabitacion numeroHabitacion,Estado estado, CantidadCama cantidadCama) {
        super("sofka.reservahabitacion.habitaciondepacienteactualizada");
        this.estado = estado;
        this.cantidadCama = cantidadCama;
        this.numeroHabitacion = numeroHabitacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public CantidadCama getCantidadCama() {
        return cantidadCama;
    }

    public NumeroHabitacion getNumeroHabitacion() {
        return numeroHabitacion;
    }
}
