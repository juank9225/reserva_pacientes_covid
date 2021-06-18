package co.com.reto.covid.domain.registrodepaciente.events;

import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;
import co.com.reto.covid.domain.registrodepaciente.values.RegistroMedico;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroMedicoActualizado extends DomainEvent {
    private final IdentificacionMedico identificacionMedico;
    private final RegistroMedico registroMedico;
    public RegistroMedicoActualizado(IdentificacionMedico identificacionMedico, RegistroMedico registroMedico) {
        super("sofka.registropersona.registromedicoactualizado");
        this.identificacionMedico = identificacionMedico;
        this.registroMedico = registroMedico;
    }

    public IdentificacionMedico getIdentificacionMedico() {
        return identificacionMedico;
    }

    public RegistroMedico getRegistroMedico() {
        return registroMedico;
    }
}
