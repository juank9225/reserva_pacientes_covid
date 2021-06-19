package co.com.reto.covid.domain.reservahabitacion.events;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;
import co.com.sofka.domain.generic.DomainEvent;

public class AdmisionAsociada extends DomainEvent {
    private final AdmisionId admisionId;

    public AdmisionAsociada(AdmisionId admisionId) {
        super("sofka.reservahabitacion.admisionasociada");
        this.admisionId = admisionId;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

}
