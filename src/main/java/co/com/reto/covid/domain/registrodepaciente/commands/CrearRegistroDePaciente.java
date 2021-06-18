package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.Fecha;
import co.com.sofka.domain.generic.Command;

public class CrearRegistroDePaciente implements Command {
    private final AdmisionId admisionId;
    private final Fecha fecha;

    public CrearRegistroDePaciente(AdmisionId admisionId, Fecha fecha) {
        this.admisionId = admisionId;
        this.fecha = fecha;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
