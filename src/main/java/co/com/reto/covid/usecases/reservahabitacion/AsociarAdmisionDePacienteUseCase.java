package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.reservahabitacion.ReservaHabitacion;
import co.com.reto.covid.domain.reservahabitacion.commands.AsociarAdmisionDePaciente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsociarAdmisionDePacienteUseCase extends UseCase<RequestCommand<AsociarAdmisionDePaciente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarAdmisionDePaciente> asociarAdmisionDePacienteRequestCommand) {
        var command = asociarAdmisionDePacienteRequestCommand.getCommand();
        var reserva = ReservaHabitacion.from(command.getNumeroReservaId(), retrieveEvents(command.getAdmisionId().value()));

        reserva.asociarAdmisionDePaciente(command.getAdmisionId(), command.getIdentificacionMedico());

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
