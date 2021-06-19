package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.reservahabitacion.ReservaHabitacion;
import co.com.reto.covid.domain.reservahabitacion.commands.AgregarHabitacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarHabitacionUseCase extends UseCase<RequestCommand<AgregarHabitacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarHabitacion> agregarHabitacionRequestCommand) {
        var command = agregarHabitacionRequestCommand.getCommand();
        var habitacion = ReservaHabitacion.from(
                command.getNumeroReservaId(), retrieveEvents(command.getNumeroReservaId().value()));
        habitacion.agregarHabitacion(command.getNumeroHabitacion(),
                command.getTipo(),
                command.getEstado(),
                command.getCantidadCama());
        emit().onResponse(new ResponseEvents(habitacion.getUncommittedChanges()));
    }
}
