package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.reservaHabitacion.values.Insumo;
import co.com.sofka.domain.generic.DomainEvent;

public class InsumoActualizado extends DomainEvent {
    private final Insumo insumo;
    public InsumoActualizado(Insumo insumo) {
        super("sofka.reservahabitacion.insumoactualizado");
        this.insumo = insumo;
    }

    public Insumo getInsumo() {
        return insumo;
    }


}
