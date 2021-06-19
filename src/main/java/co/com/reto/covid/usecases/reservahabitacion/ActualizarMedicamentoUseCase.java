package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.RegistroDePaciente;
import co.com.reto.covid.domain.reservahabitacion.ReservaHabitacion;
import co.com.reto.covid.domain.reservahabitacion.commands.ActualizarMedicamento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarMedicamentoUseCase extends UseCase<RequestCommand<ActualizarMedicamento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarMedicamento> actualizarMedicamentoRequestCommand) {
        var command = actualizarMedicamentoRequestCommand.getCommand();
        var medicamento = ReservaHabitacion.from(command.getNumeroReservaId(),
                retrieveEvents(command.getNumeroReservaId().value()));

        medicamento.actualizarMedicamento(command.getConsecutivoId(),
                command.getMedicamento());

        emit().onResponse(new ResponseEvents(medicamento.getUncommittedChanges()));
    }
}
