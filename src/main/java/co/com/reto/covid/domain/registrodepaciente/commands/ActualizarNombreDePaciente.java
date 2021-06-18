package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionPaciente;
import co.com.reto.covid.domain.registrodepaciente.values.Nombres;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDePaciente implements Command {
    private final IdentificacionPaciente identificacionPaciente;
    private final Nombres nombres;

    public ActualizarNombreDePaciente(IdentificacionPaciente identificacionPaciente, Nombres nombres) {
        this.identificacionPaciente = identificacionPaciente;
        this.nombres = nombres;
    }

    public IdentificacionPaciente getIdentificacionPaciente() {
        return identificacionPaciente;
    }

    public Nombres getNombres() {
        return nombres;
    }
}
