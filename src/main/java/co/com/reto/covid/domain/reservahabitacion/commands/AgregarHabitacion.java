package co.com.reto.covid.domain.reservahabitacion.commands;

import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.reservahabitacion.values.CantidadCama;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroHabitacion;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.reto.covid.domain.reservahabitacion.values.Tipo;

public class AgregarHabitacion {
    private final NumeroReservaId numeroReservaId;
    private final NumeroHabitacion numeroHabitacion;
    private final Tipo tipo;
    private final Estado estado;
    private final CantidadCama cantidadCama;

    public AgregarHabitacion(NumeroReservaId numeroReservaId, NumeroHabitacion numeroHabitacion, Tipo tipo, Estado estado, CantidadCama cantidadCama) {
        this.numeroReservaId = numeroReservaId;
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.estado = estado;
        this.cantidadCama = cantidadCama;
    }

    public NumeroReservaId getNumeroReservaId() {
        return numeroReservaId;
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
