package co.com.reto.covid.registroDePaciente.events;

import co.com.reto.covid.registroDePaciente.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicoAgregado extends DomainEvent {
    private final IdentificacionMedico identificacionMedico;
    private final TipoDeIdentificacion tipoDeIdentificacion;
    private final Nombres nombres;
    private final Telefono telefono;
    private final RegistroMedico registroMedico;
    private final Especialidad especialidad;

    public MedicoAgregado(IdentificacionMedico identificacionMedico, TipoDeIdentificacion tipoDeIdentificacion, Nombres nombres, Telefono telefono, RegistroMedico registroMedico, Especialidad especialidad) {
        super("sofka.registropersona.medicoagregado");
        this.identificacionMedico = identificacionMedico;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.nombres = nombres;
        this.telefono = telefono;
        this.registroMedico = registroMedico;
        this.especialidad = especialidad;
    }

    public IdentificacionMedico getIdentificacionMedico() {
        return identificacionMedico;
    }

    public TipoDeIdentificacion getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public Nombres getNombres() {
        return nombres;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public RegistroMedico getRegistroMedico() {
        return registroMedico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
