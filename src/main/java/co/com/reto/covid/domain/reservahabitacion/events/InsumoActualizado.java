package co.com.reto.covid.domain.reservahabitacion.events;

import co.com.reto.covid.domain.reservahabitacion.values.ConsecutivoId;
import co.com.reto.covid.domain.reservahabitacion.values.Insumo;
import co.com.sofka.domain.generic.DomainEvent;

public class InsumoActualizado extends DomainEvent {
    private final Insumo insumo;
    private final ConsecutivoId consecutivoId;

    public InsumoActualizado(ConsecutivoId consecutivoId,Insumo insumo) {
        super("sofka.reservahabitacion.insumoactualizado");
        this.insumo = insumo;
        this.consecutivoId = consecutivoId;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public ConsecutivoId getConsecutivoId() {
        return consecutivoId;
    }
}
