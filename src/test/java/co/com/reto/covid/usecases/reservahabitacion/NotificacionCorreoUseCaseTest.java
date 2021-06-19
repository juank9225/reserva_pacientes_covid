package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;
import co.com.reto.covid.domain.reservahabitacion.events.AdmisionAsociada;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NotificacionCorreoUseCaseTest {

    private NotificacionCorreoUseCase notificacionCorreoUseCase;

    @Mock
    private MedicoService medicoService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup() {
        notificacionCorreoUseCase = new NotificacionCorreoUseCase();
        medicoService = mock(MedicoService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder bilder = new ServiceBuilder()
                .addService(medicoService)
                .addService(senderEmailService);
        notificacionCorreoUseCase.addServiceBuilder(bilder);
    }

    @Test
    void sendEmailHappyPath() {
        //arrange
        var event = new AdmisionAsociada(
                AdmisionId.of("1111"),
                IdentificacionMedico.of("987654321")
        );

        when(medicoService.getEmailAseguradora(any())).thenReturn("juanC25@gmail.com");
        doNothing().when(senderEmailService).sendEmail(anyString(), anyString());

        //act
        UseCaseHandler.getInstance()
                .syncExecutor(notificacionCorreoUseCase, new TriggeredEvent<>(event));

        //Assert
        verify(medicoService).getEmailAseguradora(any());
        verify(senderEmailService).sendEmail(anyString(), anyString());

    }

}