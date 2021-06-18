package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.RegistroDePaciente;
import co.com.reto.covid.domain.registrodepaciente.commands.ActualizarRegistroMedico;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarRegistroMedicoUseCase extends UseCase<RequestCommand<ActualizarRegistroMedico>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarRegistroMedico> actualizarRegistroMedicoRequestCommand) {
        var command = actualizarRegistroMedicoRequestCommand.getCommand();
        var actualizarRegistroMedico = RegistroDePaciente.from(command.getAdmisionId(),
                retrieveEvents(command.getAdmisionId().value()));

        actualizarRegistroMedico.actualizarRegistroMedico(command.getIdentificacionMedico(),
                command.getRegistroMedico());

        emit().onResponse(new ResponseEvents(actualizarRegistroMedico.getUncommittedChanges()));
    }
}
