package co.com.reto.covid.domain.reservahabitacion.commands;

import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.registrodepaciente.values.Fecha;
import co.com.reto.covid.domain.registrodepaciente.values.Hora;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.sofka.domain.generic.Command;

public class CrearReservaHabitacion implements Command {
    private final NumeroReservaId numeroReservaId;
    private final Fecha fecha;
    private final Hora hora;
    private final Estado estado;

    public CrearReservaHabitacion(NumeroReservaId numeroReservaId, Fecha fecha, Hora hora, Estado estado) {
        this.numeroReservaId = numeroReservaId;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public NumeroReservaId getNumeroReservaId() {
        return numeroReservaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Hora getHora() {
        return hora;
    }

    public Estado getEstado() {
        return estado;
    }
}
