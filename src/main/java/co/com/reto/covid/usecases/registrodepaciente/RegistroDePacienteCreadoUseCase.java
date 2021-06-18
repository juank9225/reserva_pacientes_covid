package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.RegistroDePaciente;
import co.com.reto.covid.domain.registrodepaciente.commands.CrearRegistroDePaciente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class RegistroDePacienteCreadoUseCase extends UseCase<RequestCommand<CrearRegistroDePaciente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearRegistroDePaciente> crearRegistroDePacienteRequestCommand) {
        var command = crearRegistroDePacienteRequestCommand.getCommand();
        var registroDePaciente = new RegistroDePaciente(command.getAdmisionId(),command.getFecha());

        emit().onResponse(new ResponseEvents(registroDePaciente.getUncommittedChanges()));

    }
}
