package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;
import co.com.reto.covid.domain.registrodepaciente.values.RegistroMedico;
import co.com.sofka.domain.generic.Command;

public class ActualizarRegistroMedico implements Command {
    private final IdentificacionMedico identificacionMedico;
    private final RegistroMedico registroMedico;

    public ActualizarRegistroMedico(IdentificacionMedico identificacionMedico, RegistroMedico registroMedico) {
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
