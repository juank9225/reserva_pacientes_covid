package co.com.reto.covid.domain.reservahabitacion.commands;

import co.com.reto.covid.domain.reservahabitacion.values.ConsecutivoId;
import co.com.reto.covid.domain.reservahabitacion.values.Medicamento;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarMedicamento implements Command {
    private final NumeroReservaId numeroReservaId;
    private final ConsecutivoId consecutivoId;
    private final Medicamento medicamento;

    public ActualizarMedicamento(NumeroReservaId numeroReservaId, ConsecutivoId consecutivoId, Medicamento medicamento) {
        this.numeroReservaId = numeroReservaId;
        this.consecutivoId = consecutivoId;
        this.medicamento = medicamento;
    }

    public NumeroReservaId getNumeroReservaId() {
        return numeroReservaId;
    }

    public ConsecutivoId getConsecutivoId() {
        return consecutivoId;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }
}
