package co.com.reto.covid.domain.reservahabitacion.events;

import co.com.reto.covid.domain.reservahabitacion.values.IdentificacionEmpleado;
import co.com.sofka.domain.generic.DomainEvent;

public class AdmisionistaAgregado extends DomainEvent {
    private final IdentificacionEmpleado identificacionEmpleado;

    public AdmisionistaAgregado(IdentificacionEmpleado identificacionEmpleado) {
        super("sofka.reservahabitacion.admisionastaagregado");
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public IdentificacionEmpleado getIdentificacionEmpleado() {
        return identificacionEmpleado;
    }
}
