package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.RegistroDePaciente;
import co.com.reto.covid.domain.registrodepaciente.commands.AgregarEvolucion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarEvolucionUseCase extends UseCase<RequestCommand<AgregarEvolucion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEvolucion> agregarEvolucionRequestCommand) {
        var command = agregarEvolucionRequestCommand.getCommand();
        var registrarEvolucion = RegistroDePaciente.from(command.getAdmisionId(),retrieveEvents(command.getAdmisionId().value()));

        registrarEvolucion.agregarEvolucion(command.getNumeroId(),
                command.getEstado(),
                command.getTemperatura(),
                command.getSaturacionDeOxigeno(),
                command.getFrecuenciaRespiratoria(),
                command.getObservacion());

        emit().onResponse(new ResponseEvents(registrarEvolucion.getUncommittedChanges()));
    }
}
