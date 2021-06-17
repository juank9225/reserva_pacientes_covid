package co.com.reto.covid.registroDePaciente.events;

import co.com.reto.covid.registroDePaciente.values.IdentificacionMedico;
import co.com.reto.covid.registroDePaciente.values.RegistroMedico;
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
