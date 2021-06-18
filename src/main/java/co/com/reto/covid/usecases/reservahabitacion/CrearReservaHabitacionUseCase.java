package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.reservahabitacion.ReservaHabitacion;
import co.com.reto.covid.domain.reservahabitacion.commands.CrearReservaHabitacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearReservaHabitacionUseCase extends UseCase<RequestCommand<CrearReservaHabitacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearReservaHabitacion> crearReservaHabitacionRequestCommand) {
        var command = crearReservaHabitacionRequestCommand.getCommand();
        var reservaHabitacion = new ReservaHabitacion(command.getNumeroReservaId(),
                command.getFecha(),
                command.getHora(),
                command.getEstado());

        emit().onResponse(new ResponseEvents(reservaHabitacion.getUncommittedChanges()));
    }
}
