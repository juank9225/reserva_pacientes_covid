package co.com.reto.covid.registroDePaciente.events;

import co.com.reto.covid.registroDePaciente.values.IdentificacionPaciente;
import co.com.reto.covid.registroDePaciente.values.Telefono;
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
