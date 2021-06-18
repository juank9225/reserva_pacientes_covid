package co.com.reto.covid.domain.reservahabitacion.commands;

import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.reservahabitacion.values.CantidadCama;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroHabitacion;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarHabitacionDePaciente implements Command {
    private final NumeroReservaId numeroReservaId;
    private final NumeroHabitacion numeroHabitacion;
    private final Estado estado;
    private final CantidadCama cantidadCama;

    public ActualizarHabitacionDePaciente(NumeroReservaId numeroReservaId, NumeroHabitacion numeroHabitacion, Estado estado, CantidadCama cantidadCama) {
        this.numeroReservaId = numeroReservaId;
        this.numeroHabitacion = numeroHabitacion;
        this.estado = estado;
        this.cantidadCama = cantidadCama;
    }

    public NumeroReservaId getNumeroReservaId() {
        return numeroReservaId;
    }

    public NumeroHabitacion getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public CantidadCama getCantidadCama() {
        return cantidadCama;
    }
}
