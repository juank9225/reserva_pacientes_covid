package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;
import co.com.reto.covid.domain.registrodepaciente.values.RegistroMedico;
import co.com.sofka.domain.generic.Command;

public class ActualizarRegistroMedico implements Command {
    private final AdmisionId admisionId;
    private final IdentificacionMedico identificacionMedico;
    private final RegistroMedico registroMedico;

    public ActualizarRegistroMedico(AdmisionId admisionId, IdentificacionMedico identificacionMedico, RegistroMedico registroMedico) {
        this.admisionId = admisionId;
        this.identificacionMedico = identificacionMedico;
        this.registroMedico = registroMedico;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public IdentificacionMedico getIdentificacionMedico() {
        return identificacionMedico;
    }

    public RegistroMedico getRegistroMedico() {
        return registroMedico;
    }
}
