package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.RegistroDePaciente;
import co.com.reto.covid.domain.registrodepaciente.commands.ActualizarTelefonoPaciente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarTelefonoPacienteUseCase extends UseCase<RequestCommand<ActualizarTelefonoPaciente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoPaciente> actualizarTelefonoPacienteRequestCommand) {
        var command = actualizarTelefonoPacienteRequestCommand.getCommand();
        var actualizarTelefonoPaciente = RegistroDePaciente.from(command.getAdmisionId(),
                retrieveEvents(command.getAdmisionId().value()));

        actualizarTelefonoPaciente.actualizarTelefonoPaciente(command.getIdentificacionPaciente(),
                command.getTelefono());
        emit().onResponse(new ResponseEvents(actualizarTelefonoPaciente.getUncommittedChanges()));
    }
}
