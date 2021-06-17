package co.com.reto.covid.registroDePaciente;

import co.com.reto.covid.registroDePaciente.values.*;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Medico extends Entity<IdentificacionMedico> {

    protected TipoDeIdentificacion tipoDeIdentificacion;
    protected Nombres nombres;
    protected Telefono telefono;
    protected RegistroMedico registroMedico;
    protected Especialidad especialidad;

    public Medico(IdentificacionMedico identificacionMedico,TipoDeIdentificacion tipoDeIdentificacion,Nombres nombres,Telefono telefono,RegistroMedico registroMedico,Especialidad especialidad) {
        super(identificacionMedico);
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.nombres = nombres;
        this.telefono = telefono;
        this.registroMedico = registroMedico;
        this.especialidad = especialidad;
    }

    public void actualizarNombreMedico(Nombres nombres){
        this.nombres = Objects.requireNonNull(nombres);
    }

    public void actualizarTelefonoMedico(Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono);
    }

    public void actualizarEspecialidadMedico(Especialidad especialidad){
        this.especialidad = Objects.requireNonNull(especialidad);
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

    public RegistroMedico RegistroMedico() {
        return registroMedico;
    }

    public Especialidad Especialidad() {
        return especialidad;
    }
}
