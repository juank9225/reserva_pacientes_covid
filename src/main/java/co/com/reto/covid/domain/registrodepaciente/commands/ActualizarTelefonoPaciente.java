package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionPaciente;
import co.com.reto.covid.domain.registrodepaciente.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class ActualizarTelefonoPaciente implements Command {
    private final AdmisionId admisionId;
    private final IdentificacionPaciente identificacionPaciente;
    private final Telefono telefono;

    public ActualizarTelefonoPaciente(AdmisionId admisionId, IdentificacionPaciente identificacionPaciente, Telefono telefono) {
        this.admisionId = admisionId;
        this.identificacionPaciente = identificacionPaciente;
        this.telefono = telefono;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public IdentificacionPaciente getIdentificacionPaciente() {
        return identificacionPaciente;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
