package co.com.reto.covid.domain.reservahabitacion.commands;

import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroHabitacion;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoDeHabitacion implements Command {
    private final NumeroReservaId numeroReservaId;
    private final NumeroHabitacion numeroHabitacion;
    private final Estado estado;

    public ActualizarEstadoDeHabitacion(NumeroReservaId numeroReservaId, NumeroHabitacion numeroHabitacion, Estado estado) {
        this.numeroReservaId = numeroReservaId;
        this.numeroHabitacion = numeroHabitacion;
        this.estado = estado;
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
}
