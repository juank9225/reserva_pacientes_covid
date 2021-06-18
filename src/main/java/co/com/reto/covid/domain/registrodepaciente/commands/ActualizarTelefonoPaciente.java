package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionPaciente;
import co.com.reto.covid.domain.registrodepaciente.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class ActualizarTelefonoPaciente implements Command {
    private final IdentificacionPaciente identificacionPaciente;
    private final Telefono telefono;

    public ActualizarTelefonoPaciente(IdentificacionPaciente identificacionPaciente, Telefono telefono) {
        this.identificacionPaciente = identificacionPaciente;
        this.telefono = telefono;
    }

    public IdentificacionPaciente getIdentificacionPaciente() {
        return identificacionPaciente;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
