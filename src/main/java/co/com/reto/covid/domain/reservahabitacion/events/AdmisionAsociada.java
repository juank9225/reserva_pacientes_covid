package co.com.reto.covid.domain.reservahabitacion.events;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.sofka.domain.generic.DomainEvent;

public class AdmisionAsociada extends DomainEvent {
    private AdmisionId admisionId;
    public AdmisionAsociada(AdmisionId admisionId) {
        super("sofka.reservahabitacion.admisionasociada");
        this.admisionId = admisionId;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }
}
