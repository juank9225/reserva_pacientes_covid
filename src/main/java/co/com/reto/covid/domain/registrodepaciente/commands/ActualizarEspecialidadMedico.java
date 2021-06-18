package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.Especialidad;
import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;
import co.com.sofka.domain.generic.Command;

public class ActualizarEspecialidadMedico implements Command {
    private final AdmisionId admisionId;
    private final IdentificacionMedico identificacionMedico;
    private final Especialidad especialidad;

    public ActualizarEspecialidadMedico(AdmisionId admisionId, IdentificacionMedico identificacionMedico, Especialidad especialidad) {
        this.admisionId = admisionId;
        this.identificacionMedico = identificacionMedico;
        this.especialidad = especialidad;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public IdentificacionMedico getIdentificacionMedico() {
        return identificacionMedico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
