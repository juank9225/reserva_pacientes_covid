package co.com.reto.covid.registroDePaciente.events;

import co.com.reto.covid.registroDePaciente.values.IdentificacionPaciente;
import co.com.reto.covid.registroDePaciente.values.Nombres;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDePacienteActualizado extends DomainEvent {
    private final IdentificacionPaciente identificacionPaciente;
    private final Nombres nombres;
    public NombreDePacienteActualizado(IdentificacionPaciente identificacionPaciente, Nombres nombres) {
        super("sofka.registropersona.nombredepacienteactualizado");
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
