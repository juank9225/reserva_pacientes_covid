package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarPaciente implements Command {
    private final AdmisionId admisionId;
    private final IdentificacionPaciente identificacionPaciente;
    private final TipoDeIdentificacion tipoDeIdentificacion;
    private final Nombres nombres;
    private final Telefono telefono;
    private final Eps eps;

    public AgregarPaciente(AdmisionId admisionId, IdentificacionPaciente identificacionPaciente, TipoDeIdentificacion tipoDeIdentificacion, Nombres nombres, Telefono telefono, Eps eps) {
        this.admisionId = admisionId;
        this.identificacionPaciente = identificacionPaciente;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.nombres = nombres;
        this.telefono = telefono;
        this.eps = eps;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public IdentificacionPaciente getIdentificacionPaciente() {
        return identificacionPaciente;
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

    public Eps getEps() {
        return eps;
    }
}
