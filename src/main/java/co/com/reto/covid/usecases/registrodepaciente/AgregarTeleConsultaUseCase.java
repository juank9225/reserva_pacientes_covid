package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.RegistroDePaciente;
import co.com.reto.covid.domain.registrodepaciente.commands.AgregarTeleConsulta;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarTeleConsultaUseCase extends UseCase<RequestCommand<AgregarTeleConsulta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTeleConsulta> agregarTeleConsultaRequestCommand) {
        var command = agregarTeleConsultaRequestCommand.getCommand();
        var registrarTeleConsulta = RegistroDePaciente.from(command.getAdmisionId(),retrieveEvents(command.getAdmisionId().value()));

        registrarTeleConsulta.agregarTeleConsulta(command.getRadicadoId(),
                command.getFecha(),
                command.getHora(),
                command.getSatisfaccion());
        emit().onResponse(new ResponseEvents(registrarTeleConsulta.getUncommittedChanges()));
    }
}
