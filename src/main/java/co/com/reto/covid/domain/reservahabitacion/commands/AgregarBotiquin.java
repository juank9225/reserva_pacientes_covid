package co.com.reto.covid.domain.reservahabitacion.commands;

import co.com.reto.covid.domain.reservahabitacion.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarBotiquin implements Command {
    private final NumeroReservaId numeroReservaId;
    private final ConsecutivoId consecutivoId;
    private final Tipo tipo;
    private final Medicamento medicamento;
    private final Insumo insumo;

    public AgregarBotiquin(NumeroReservaId numeroReservaId, ConsecutivoId consecutivoId, Tipo tipo, Medicamento medicamento, Insumo insumo) {
        this.numeroReservaId = numeroReservaId;
        this.consecutivoId = consecutivoId;
        this.tipo = tipo;
        this.medicamento = medicamento;
        this.insumo = insumo;
    }

    public NumeroReservaId getNumeroReservaId() {
        return numeroReservaId;
    }

    public ConsecutivoId getConsecutivoId() {
        return consecutivoId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public Insumo getInsumo() {
        return insumo;
    }
}
