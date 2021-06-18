package co.com.reto.covid.domain.registrodepaciente.events;

import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionPaciente;
import co.com.reto.covid.domain.registrodepaciente.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class TelefonoDePacienteActualizado extends DomainEvent {
    private final IdentificacionPaciente identificacionPaciente;
    private final Telefono telefono;

    public TelefonoDePacienteActualizado(IdentificacionPaciente identificacionPaciente, Telefono telefono) {
        super("sofka.registropersona.telefonodepacienteactualizado");
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
