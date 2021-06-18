package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.reservaHabitacion.values.ConsecutivoId;
import co.com.reto.covid.reservaHabitacion.values.Insumo;
import co.com.reto.covid.reservaHabitacion.values.Medicamento;
import co.com.reto.covid.reservaHabitacion.values.Tipo;
import co.com.sofka.domain.generic.DomainEvent;

public class BotiquinAgregado extends DomainEvent {
    private final ConsecutivoId consecutivoId;
    private final Tipo tipo;
    private final Medicamento medicamento;
    private final Insumo insumo;
    public BotiquinAgregado(ConsecutivoId consecutivoId, Tipo tipo, Medicamento medicamento, Insumo insumo) {
        super("sofka.reservahabitacion.botiquinagregado");
        this.consecutivoId = consecutivoId;
        this.tipo = tipo;
        this.medicamento = medicamento;
        this.insumo = insumo;
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
