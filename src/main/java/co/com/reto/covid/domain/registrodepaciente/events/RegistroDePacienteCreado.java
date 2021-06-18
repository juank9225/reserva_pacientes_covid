package co.com.reto.covid.domain.registrodepaciente.events;

import co.com.reto.covid.domain.registrodepaciente.values.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroDePacienteCreado extends DomainEvent {
    private final Fecha fecha;

    public RegistroDePacienteCreado(Fecha fecha) {
        super("sofka.registropersona.registrodepacientecreado");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
