package co.com.reto.covid.domain.reservahabitacion.commands;

import co.com.reto.covid.domain.reservahabitacion.values.ConsecutivoId;
import co.com.reto.covid.domain.reservahabitacion.values.Insumo;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarInsumo implements Command {
    private final NumeroReservaId numeroReservaId;
    private final ConsecutivoId consecutivoId;
    private final Insumo insumo;

    public ActualizarInsumo(NumeroReservaId numeroReservaId, ConsecutivoId consecutivoId, Insumo insumo) {
        this.numeroReservaId = numeroReservaId;
        this.consecutivoId = consecutivoId;
        this.insumo = insumo;
    }

    public NumeroReservaId getNumeroReservaId() {
        return numeroReservaId;
    }

    public ConsecutivoId getConsecutivoId() {
        return consecutivoId;
    }

    public Insumo getInsumo() {
        return insumo;
    }
}
