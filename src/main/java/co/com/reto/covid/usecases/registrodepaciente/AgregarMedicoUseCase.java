package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.RegistroDePaciente;
import co.com.reto.covid.domain.registrodepaciente.commands.AgregarMedico;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarMedicoUseCase extends UseCase<RequestCommand<AgregarMedico>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMedico> agregarMedicoRequestCommand) {
        var command = agregarMedicoRequestCommand.getCommand();
       var registrarMedico = RegistroDePaciente.from(command.getAdmisionId(),retrieveEvents(command.getAdmisionId().value()));

       registrarMedico.agregarMedico(command.getIdentificacionMedico(),
               command.getTipoDeIdentificacion(),
               command.getNombres(),
               command.getTelefono(),
               command.getRegistroMedico(),
               command.getEspecialidad());

        emit().onResponse(new ResponseEvents(registrarMedico.getUncommittedChanges()));
    }
}
