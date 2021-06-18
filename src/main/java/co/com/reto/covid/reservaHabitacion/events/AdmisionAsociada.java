package co.com.reto.covid.reservaHabitacion.events;

import co.com.reto.covid.registroDePaciente.values.AdmisionId;
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
