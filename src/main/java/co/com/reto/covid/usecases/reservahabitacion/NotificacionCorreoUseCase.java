package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.reservahabitacion.events.AdmisionAsociada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class NotificacionCorreoUseCase extends UseCase<TriggeredEvent<AdmisionAsociada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AdmisionAsociada> admisionAsociadaTriggeredEvent) {
        var event = admisionAsociadaTriggeredEvent.getDomainEvent();
        var aseguradoraService = getService(MedicoService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();

        var email = aseguradoraService.getEmailAseguradora(event.getIdentificacionMedico());
        sender.sendEmail(email, "contet body");

    }
}
