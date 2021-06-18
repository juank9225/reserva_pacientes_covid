package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.reservaHabitacion.values.ConsecutivoId;
import co.com.reto.covid.reservaHabitacion.values.Medicamento;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicamentoActualizado extends DomainEvent {
    private final Medicamento medicamento;
    private final ConsecutivoId consecutivoId;

    public MedicamentoActualizado(ConsecutivoId consecutivoId,Medicamento medicamento) {
        super("sofka.reservahabitacion.medicamentoactualizado");
        this.medicamento = medicamento;
        this.consecutivoId = consecutivoId;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public ConsecutivoId getConsecutivoId() {
        return consecutivoId;
    }
}
