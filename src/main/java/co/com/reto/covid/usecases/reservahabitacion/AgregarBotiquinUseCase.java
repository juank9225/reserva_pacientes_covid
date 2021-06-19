package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.reservahabitacion.ReservaHabitacion;
import co.com.reto.covid.domain.reservahabitacion.commands.AgregarBotiquin;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarBotiquinUseCase extends UseCase<RequestCommand<AgregarBotiquin>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarBotiquin> agregarBotiquinRequestCommand) {
        var command = agregarBotiquinRequestCommand.getCommand();
        var habitacion = ReservaHabitacion.from(
                command.getNumeroReservaId(), retrieveEvents(command.getNumeroReservaId().value()));
        habitacion.agregarBotiquin(command.getConsecutivoId(),
                command.getTipo(),
                command.getMedicamento(),
                command.getInsumo());
        emit().onResponse(new ResponseEvents(habitacion.getUncommittedChanges()));
    }
}
