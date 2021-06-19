package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.registrodepaciente.values.Fecha;
import co.com.reto.covid.domain.registrodepaciente.values.Hora;
import co.com.reto.covid.domain.reservahabitacion.commands.AgregarBotiquin;
import co.com.reto.covid.domain.reservahabitacion.events.AdmisionAsociada;
import co.com.reto.covid.domain.reservahabitacion.events.HabitacionAgregada;
import co.com.reto.covid.domain.reservahabitacion.events.ReservaHabitacionAgregada;
import co.com.reto.covid.domain.reservahabitacion.values.*;
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

class AgregarBotiquinUseCaseTest {

    private AgregarBotiquinUseCase agregarBotiquinUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        agregarBotiquinUseCase = new AgregarBotiquinUseCase();
        repository = mock(DomainEventRepository.class);
        agregarBotiquinUseCase.addRepository(repository);
    }

    @Test
    void setAgregarBotiquinUseCaseHappyPath(){
        var command = new AgregarBotiquin(
                NumeroReservaId.of("5555"),
                new ConsecutivoId("01"),
                new Tipo("Pacientes covid 19"),
                new Medicamento("Corticoides"),
                new Insumo("caja de tapa bocas")
        );

        when(repository.getEventsBy(any())).thenReturn(events());
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("5555")
                .syncExecutor(
                        agregarBotiquinUseCase,
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
                new AdmisionId("1111")
        ),new HabitacionAgregada(
                new NumeroHabitacion("21"),
                new Tipo("empresarial"),
                new Estado("aseada y en exelemte estado"),
                new CantidadCama(1)
        ));
    }
}