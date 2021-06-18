package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.RegistroDePaciente;
import co.com.reto.covid.domain.registrodepaciente.commands.AgregarPaciente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarPacienteUseCase extends UseCase<RequestCommand<AgregarPaciente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPaciente> agregarPacienteRequestCommand) {
        var command = agregarPacienteRequestCommand.getCommand();
        var registroDePaciente = RegistroDePaciente.from(
                command.getAdmisionId(), retrieveEvents(command.getAdmisionId().value()));

        registroDePaciente.agregarPaciente(command.getIdentificacionPaciente(),
                command.getTipoDeIdentificacion(),
                command.getNombres(),
                command.getTelefono(),
                command.getEps());

        emit().onResponse(new ResponseEvents(registroDePaciente.getUncommittedChanges()));
    }
}
