package co.com.reto.covid.domain.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class RegistroDePacienteChange extends EventChange {

    public RegistroDePacienteChange(RegistroDePaciente registroDePaciente) {

        apply((RegistroDePacienteCreado event) -> {
            registroDePaciente.fecha = event.getFecha();
            registroDePaciente.pacientes = new HashSet<>();
            registroDePaciente.medicos = new HashSet<>();
            registroDePaciente.evoluciones = new HashSet<>();
            registroDePaciente.teleConsultas = new HashSet<>();
        });

        apply((PacienteAgregado event) -> {
            registroDePaciente.pacientes.add(new Paciente(
                    event.getIdentificacionPaciente(),
                    event.getTipoDeIdentificacion(),
                    event.getNombres(),
                    event.getTelefono(),
                    event.getEps()
            ));
        });

        apply((MedicoAgregado event) -> {
            registroDePaciente.medicos.add(new Medico(
                    event.getIdentificacionMedico(),
                    event.getTipoDeIdentificacion(),
                    event.getNombres(),
                    event.getTelefono(),
                    event.getRegistroMedico(),
                    event.getEspecialidad()
            ));
        });

        apply((EvolucionAgregada event) -> {
            registroDePaciente.evoluciones.add(new Evolucion(
                    event.getNumeroId(),
                    event.getEstado(),
                    event.getTemperatura(),
                    event.getSaturacionDeOxigeno(),
                    event.getFrecuenciaRespiratoria(),
                    event.getObservacion()
            ));
        });

        apply((TeleConsultaAgregada event) -> {
            registroDePaciente.teleConsultas.add(new TeleConsulta(
                    event.getRadicadoId(),
                    event.getFecha(),
                    event.getHora(),
                    event.getSatisfaccion()
            ));
        });

        apply((NombreDePacienteActualizado event) -> {
            var paciente = registroDePaciente.getPacientePorId(event.getIdentificacionPaciente())
                    .orElseThrow(() -> new IllegalArgumentException("no se encontro el Id de la persona"));
            paciente.actualizarNombrePaciente(event.getNombres());
        });

        apply((TelefonoDePacienteActualizado event) -> {
            var paciente = registroDePaciente.getPacientePorId(event.getIdentificacionPaciente())
                    .orElseThrow(() -> new IllegalArgumentException("no se encontro el Id de la persona"));
            paciente.actualizarTelefonoPaciente(event.getTelefono());
        });

        apply((RegistroMedicoActualizado event) -> {
            var medico = registroDePaciente.getMedicoPorId(event.getIdentificacionMedico())
                    .orElseThrow(() -> new IllegalArgumentException("no se encontro el Id del medico"));
            medico.actualizarRegistroMedico(event.getRegistroMedico());
        });

        apply((EspecialidadDelMedicoActualizada event) -> {
            var medico = registroDePaciente.getMedicoPorId(event.getIdentificacionMedico())
                    .orElseThrow(() -> new IllegalArgumentException("no se encontro el Id del medico"));
            medico.actualizarEspecialidadMedico(event.getEspecialidad());
        });

        apply((EvolucionActualizada event) -> {
            var evolucion = registroDePaciente.getEvolucionPorNumero(event.getNumeroId())
                    .orElseThrow(() -> new IllegalArgumentException("no se encontro la evolucion"));
            evolucion.actualizarEvolucion(event.getEstado(),
                    event.getTemperatura(),
                    event.getSaturacionDeOxigeno(),
                    event.getFrecuenciaRespiratoria(),
                    event.getObservacion());
        });

        apply((TeleConsultaActualizada event) -> {
            var teleConsulta = registroDePaciente.getTeleConsultaPorId(event.getRadicadoId())
                    .orElseThrow(() -> new IllegalArgumentException("no se encontro el radicado"));
            teleConsulta.actualizarTeleConsulta(event.getFecha(),
                    event.getHora(),
                    event.getSatisfaccion());
        });
    }
}
