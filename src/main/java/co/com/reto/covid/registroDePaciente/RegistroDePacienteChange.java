package co.com.reto.covid.registroDePaciente;

import co.com.reto.covid.registroDePaciente.events.RegistroDePacienteCreado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class RegistroDePacienteChange extends EventChange {

    public RegistroDePacienteChange(RegistroDePaciente registroDePaciente) {

        apply((RegistroDePacienteCreado event)->{
            registroDePaciente.fecha = event.getFecha();
            registroDePaciente.pacientes = new HashSet<>();
            registroDePaciente.medicos = new HashSet<>();
            registroDePaciente.evoluciones = new HashSet<>();
            registroDePaciente.teleConsultas = new HashSet<>();
        });
    }
}
