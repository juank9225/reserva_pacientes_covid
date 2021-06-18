package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionPaciente;
import co.com.reto.covid.domain.registrodepaciente.values.Nombres;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDePaciente implements Command {
    private final AdmisionId admisionId;
    private final IdentificacionPaciente identificacionPaciente;
    private final Nombres nombres;

    public ActualizarNombreDePaciente(AdmisionId admisionId, IdentificacionPaciente identificacionPaciente, Nombres nombres) {
        this.admisionId = admisionId;
        this.identificacionPaciente = identificacionPaciente;
        this.nombres = nombres;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public IdentificacionPaciente getIdentificacionPaciente() {
        return identificacionPaciente;
    }

    public Nombres getNombres() {
        return nombres;
    }
}
