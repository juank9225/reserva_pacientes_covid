package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.values.*;
import co.com.reto.covid.domain.reservahabitacion.commands.AgregarHabitacion;
import co.com.reto.covid.domain.reservahabitacion.commands.AsociarAdmisionDePaciente;
import co.com.reto.covid.domain.reservahabitacion.events.AdmisionAsociada;
import co.com.reto.covid.domain.reservahabitacion.events.ReservaHabitacionAgregada;
import co.com.reto.covid.domain.reservahabitacion.values.CantidadCama;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroHabitacion;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.reto.covid.domain.reservahabitacion.values.Tipo;
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

class AgregarHabitacionUseCaseTest {

    private AgregarHabitacionUseCase agregarHabitacionUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        agregarHabitacionUseCase = new AgregarHabitacionUseCase();
        repository = mock(DomainEventRepository.class);
        agregarHabitacionUseCase.addRepository(repository);
    }

    @Test
    void agregarHabitacionHappyPath(){

        var command = new AgregarHabitacion(
                NumeroReservaId.of("5555"),
                new NumeroHabitacion("21"),
                new Tipo("empresarial"),
                new Estado("aseada y en exelemte estado"),
                new CantidadCama(1)
        );

        when(repository.getEventsBy(any())).thenReturn(events());
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("5555")
                .syncExecutor(
                        agregarHabitacionUseCase,
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
                new AdmisionId("1111"),
                new IdentificacionMedico("987654321")
        ));
    }
}