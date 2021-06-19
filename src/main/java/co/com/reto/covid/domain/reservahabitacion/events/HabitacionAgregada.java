package co.com.reto.covid.domain.reservahabitacion.events;

import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.reservahabitacion.values.CantidadCama;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroHabitacion;
import co.com.reto.covid.domain.reservahabitacion.values.Tipo;
import co.com.sofka.domain.generic.DomainEvent;

public class HabitacionAgregada extends DomainEvent {
    private final NumeroHabitacion numeroHabitacion;
    private final Tipo tipo;
    private final Estado estado;
    private final CantidadCama cantidadCama;

    public HabitacionAgregada(NumeroHabitacion numeroHabitacion, Tipo tipo, Estado estado, CantidadCama cantidadCama) {
        super("sofka.reservahabitacion.habitacionagregada");
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.estado = estado;
        this.cantidadCama = cantidadCama;
    }

    public NumeroHabitacion getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public CantidadCama getCantidadCama() {
        return cantidadCama;
    }
}
