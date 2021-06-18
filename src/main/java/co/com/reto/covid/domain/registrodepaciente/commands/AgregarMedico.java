package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarMedico implements Command {
    private final AdmisionId admisionId;
    private final IdentificacionMedico identificacionMedico;
    private final TipoDeIdentificacion tipoDeIdentificacion;
    private final Nombres nombres;
    private final Telefono telefono;
    private final RegistroMedico registroMedico;
    private final Especialidad especialidad;

    public AgregarMedico(AdmisionId admisionId, IdentificacionMedico identificacionMedico, TipoDeIdentificacion tipoDeIdentificacion, Nombres nombres, Telefono telefono, RegistroMedico registroMedico, Especialidad especialidad) {
        this.admisionId = admisionId;
        this.identificacionMedico = identificacionMedico;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.nombres = nombres;
        this.telefono = telefono;
        this.registroMedico = registroMedico;
        this.especialidad = especialidad;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
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
