package co.com.reto.covid.domain.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.events.*;
import co.com.reto.covid.domain.registrodepaciente.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class RegistroDePaciente extends AggregateEvent<AdmisionId> {
    protected Fecha fecha;
    protected Set<Paciente> pacientes;
    protected Set<Medico> medicos;
    protected Set<Evolucion> evoluciones;
    protected Set<TeleConsulta> teleConsultas;

    public RegistroDePaciente(AdmisionId entityId, Fecha fecha) {
        super(entityId);
        appendChange(new RegistroDePacienteCreado(fecha)).apply();
    }

    private RegistroDePaciente(AdmisionId entityId) {
        super(entityId);
        subscribe(new RegistroDePacienteChange(this));
    }

    public static RegistroDePaciente from(AdmisionId admisionId, List<DomainEvent> events) {
        var registroDePaciente = new RegistroDePaciente(admisionId);
        events.forEach(registroDePaciente::applyEvent);
        return registroDePaciente;
    }

    public void agregarPaciente(IdentificacionPaciente identificacionPaciente, TipoDeIdentificacion tipoDeIdentificacion, Nombres nombres, Telefono telefono, Eps eps) {
        Objects.requireNonNull(identificacionPaciente);
        Objects.requireNonNull(tipoDeIdentificacion);
        Objects.requireNonNull(nombres);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(eps);
        appendChange(new PacienteAgregado(identificacionPaciente
                , tipoDeIdentificacion
                , nombres
                , telefono
                , eps)).apply();
    }

    public void agregarMedico(IdentificacionMedico identificacionMedico, TipoDeIdentificacion tipoDeIdentificacion, Nombres nombres, Telefono telefono, RegistroMedico registroMedico, Especialidad especialidad) {
        Objects.requireNonNull(identificacionMedico);
        Objects.requireNonNull(tipoDeIdentificacion);
        Objects.requireNonNull(nombres);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(registroMedico);
        Objects.requireNonNull(especialidad);
        appendChange(new MedicoAgregado(identificacionMedico
                , tipoDeIdentificacion
                , nombres
                , telefono
                , registroMedico
                , especialidad)).apply();
    }

    public void agregarEvolucion(NumeroId numeroId, Estado estado, Temperatura temperatura, SaturacionDeOxigeno saturacionDeOxigeno, FrecuenciaRespiratoria frecuenciaRespiratoria, Observacion observacion) {
        Objects.requireNonNull(numeroId);
        Objects.requireNonNull(estado);
        Objects.requireNonNull(temperatura);
        Objects.requireNonNull(saturacionDeOxigeno);
        Objects.requireNonNull(frecuenciaRespiratoria);
        Objects.requireNonNull(observacion);
        appendChange(new EvolucionAgregada(numeroId,
                estado,
                temperatura,
                saturacionDeOxigeno,
                frecuenciaRespiratoria,
                observacion)).apply();
    }

    public void agregarTeleConsulta(RadicadoId radicadoId, Fecha fecha, Hora hora, Satisfaccion satisfaccion) {
        Objects.requireNonNull(radicadoId);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(hora);
        Objects.requireNonNull(satisfaccion);
        appendChange(new TeleConsultaAgregada(radicadoId,
                fecha,
                hora,
                satisfaccion)).apply();
    }

    public void actualizarNombreDePaciente(IdentificacionPaciente identificacionPaciente, Nombres nombres) {
        appendChange(new NombreDePacienteActualizado(identificacionPaciente, nombres)).apply();
    }

    public void actualizarTelefonoPaciente(IdentificacionPaciente identificacionPaciente, Telefono telefono) {
        appendChange(new TelefonoDePacienteActualizado(identificacionPaciente, telefono)).apply();
    }

    public void actualizarRegistroMedico(IdentificacionMedico identificacionMedico, RegistroMedico registroMedico) {
        appendChange(new RegistroMedicoActualizado(identificacionMedico, registroMedico)).apply();
    }

    public void actualizarEspecialidadMedico(IdentificacionMedico identificacionMedico, Especialidad especialidad) {
        appendChange(new EspecialidadDelMedicoActualizada(identificacionMedico, especialidad)).apply();
    }

    public void actualizarEvolucion(NumeroId numeroId, Estado estado, Temperatura temperatura, SaturacionDeOxigeno saturacionDeOxigeno, FrecuenciaRespiratoria frecuenciaRespiratoria, Observacion observacion) {

        appendChange(new EvolucionActualizada(numeroId,
                estado,
                temperatura,
                saturacionDeOxigeno,
                frecuenciaRespiratoria,
                observacion)).apply();
    }

    public void actualizarTeleConsulta(RadicadoId radicadoId, Fecha fecha, Hora hora, Satisfaccion satisfaccion) {

        appendChange(new TeleConsultaActualizada(radicadoId,
                fecha,
                hora,
                satisfaccion)).apply();
    }

    protected Optional<Paciente> getPacientePorId(IdentificacionPaciente identificacionPaciente) {
        return pacientes
                .stream()
                .filter(paciente -> paciente.identity().equals(identificacionPaciente))
                .findFirst();
    }

    protected Optional<Evolucion> getEvolucionPorNumero(NumeroId numeroId) {
        return evoluciones
                .stream()
                .filter(evolucion -> evolucion.identity().equals(numeroId))
                .findFirst();
    }

    protected Optional<Medico> getMedicoPorId(IdentificacionMedico identificacionMedico) {
        return medicos
                .stream()
                .filter(medico -> medico.identity().equals(identificacionMedico))
                .findFirst();
    }


    protected Optional<TeleConsulta> getTeleConsultaPorId(RadicadoId radicadoId) {
        return teleConsultas
                .stream()
                .filter(teleConsulta -> teleConsulta.identity().equals(radicadoId))
                .findFirst();
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public Set<Medico> getMedicos() {
        return medicos;
    }

    public Set<Evolucion> getEvoluciones() {
        return evoluciones;
    }

    public Set<TeleConsulta> getTeleConsultas() {
        return teleConsultas;
    }
}
