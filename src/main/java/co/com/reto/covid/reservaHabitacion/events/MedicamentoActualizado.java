package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.reservaHabitacion.values.Medicamento;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicamentoActualizado extends DomainEvent {
    private final Medicamento medicamento;

    public MedicamentoActualizado(Medicamento medicamento) {
        super("sofka.reservahabitacion.medicamentoactualizado");
        this.medicamento = medicamento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }
}
