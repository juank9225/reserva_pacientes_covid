package co.com.reto.covid.domain.registrodepaciente.events;

import co.com.reto.covid.domain.registrodepaciente.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class PacienteAgregado extends DomainEvent {
    private final IdentificacionPaciente identificacionPaciente;
    private final TipoDeIdentificacion tipoDeIdentificacion;
    private final Nombres nombres;
    private final Telefono telefono;
    private final Eps eps;

    public PacienteAgregado(IdentificacionPaciente identificacionPaciente, TipoDeIdentificacion tipoDeIdentificacion, Nombres nombres, Telefono telefono, Eps eps) {
        super("sofka.registropersona.pacienteagregado");
        this.identificacionPaciente = identificacionPaciente;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.nombres = nombres;
        this.telefono = telefono;
        this.eps = eps;
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
