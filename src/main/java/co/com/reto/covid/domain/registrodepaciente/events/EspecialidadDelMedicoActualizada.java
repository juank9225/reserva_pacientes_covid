package co.com.reto.covid.domain.registrodepaciente.events;

import co.com.reto.covid.domain.registrodepaciente.values.Especialidad;
import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;
import co.com.sofka.domain.generic.DomainEvent;

public class EspecialidadDelMedicoActualizada extends DomainEvent {
    private final IdentificacionMedico identificacionMedico;
    private final Especialidad especialidad;

    public EspecialidadDelMedicoActualizada(IdentificacionMedico identificacionMedico, Especialidad especialidad) {
        super("sofka.registropersona.especialidaddelmedicoactualizada");
        this.identificacionMedico = identificacionMedico;
        this.especialidad = especialidad;
    }

    public IdentificacionMedico getIdentificacionMedico() {
        return identificacionMedico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
