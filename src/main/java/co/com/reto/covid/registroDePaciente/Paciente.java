package co.com.reto.covid.registroDePaciente;

import co.com.reto.covid.registroDePaciente.values.*;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Paciente extends Entity<IdentificacionPaciente> {

    protected TipoDeIdentificacion tipoDeIdentificacion;
    protected Nombres nombres;
    protected Telefono telefono;
    protected Eps eps;

    public Paciente(IdentificacionPaciente identificacionPaciente,TipoDeIdentificacion tipoDeIdentificacion,Nombres nombres,Telefono telefono,Eps eps) {
        super(identificacionPaciente);
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.nombres = nombres;
        this.telefono = telefono;
        this.eps = eps;
    }

    public void actualizarNombrePaciente(Nombres nombres){
        this.nombres = Objects.requireNonNull(nombres);
    }

    public void actualizarTelefonoPaciente(Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono);
    }

    public void actualizarEpsPaciente(Eps eps){
        this.eps = Objects.requireNonNull(eps);
    }

    public TipoDeIdentificacion TipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public Nombres Nombres() {
        return nombres;
    }

    public Telefono Telefono() {
        return telefono;
    }

    public Eps Eps() {
        return eps;
    }
}
