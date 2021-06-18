package co.com.reto.covid.domain.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.reservahabitacion.values.*;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Habitacion extends Entity<NumeroHabitacion> {
    protected Tipo tipo;
    protected Estado estado;
    protected CantidadCama cantidadCama;

    public Habitacion(NumeroHabitacion numeroHabitacion,Tipo tipo,Estado estado,CantidadCama cantidadCama) {
        super(numeroHabitacion);
        this.tipo = tipo;
        this.estado = estado;
        this.cantidadCama = cantidadCama;
    }

    public void actualizarHabitacion(Estado estado, CantidadCama cantidadCama){
        this.estado = Objects.requireNonNull(estado);
        this.cantidadCama = Objects.requireNonNull(cantidadCama);
    }
     public void actualizarEstadoHabitacion(Estado estado){
        this.estado = Objects.requireNonNull(estado);
     }

    public Tipo Tipo() {
        return tipo;
    }

    public Estado Estado() {
        return estado;
    }

    public CantidadCama CantidadCama() {
        return cantidadCama;
    }
}