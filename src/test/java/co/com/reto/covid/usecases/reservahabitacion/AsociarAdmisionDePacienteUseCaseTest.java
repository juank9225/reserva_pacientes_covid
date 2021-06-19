package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.values.*;
import co.com.reto.covid.domain.reservahabitacion.commands.AsociarAdmisionDePaciente;
import co.com.reto.covid.domain.reservahabitacion.events.AdmisionAsociada;
import co.com.reto.covid.domain.reservahabitacion.events.ReservaHabitacionAgregada;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AsociarAdmisionDePacienteUseCaseTest {

    private AsociarAdmisionDePacienteUseCase asociarAdmisionDePacienteUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        asociarAdmisionDePacienteUseCase = new AsociarAdmisionDePacienteUseCase();
        repository = mock(DomainEventRepository.class);
        asociarAdmisionDePacienteUseCase.addRepository(repository);
    }

    @Test
    void asociarAdminsioHappyPath(){
        var command = new AsociarAdmisionDePaciente(
                NumeroReservaId.of("5555"),
                new AdmisionId("1111")
        );

        when(repository.getEventsBy(any())).thenReturn(events());
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("5555")
                .syncExecutor(
                        asociarAdmisionDePacienteUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        System.out.println(response);
    }

    private List<DomainEvent> events() {
        return List.of(new ReservaHabitacionAgregada(
                new Fecha(new Date(1990,05,20)),
                new Hora("05:00 pm"),
                new Estado("no registra pago")
        ),new AdmisionAsociada(
                AdmisionId.of("1111"),
                IdentificacionMedico.of("987654321")
        ));
    }

}