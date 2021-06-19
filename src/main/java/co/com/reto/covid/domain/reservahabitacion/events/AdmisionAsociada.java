package co.com.reto.covid.domain.reservahabitacion.events;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;
import co.com.sofka.domain.generic.DomainEvent;

public class AdmisionAsociada extends DomainEvent {
    private final AdmisionId admisionId;
    private final IdentificacionMedico identificacionMedico;

    public AdmisionAsociada(AdmisionId admisionId,IdentificacionMedico identificacionMedico) {
        super("sofka.reservahabitacion.admisionasociada");
        this.admisionId = admisionId;
        this.identificacionMedico = identificacionMedico;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public IdentificacionMedico getIdentificacionMedico() {
        return identificacionMedico;
    }
}
