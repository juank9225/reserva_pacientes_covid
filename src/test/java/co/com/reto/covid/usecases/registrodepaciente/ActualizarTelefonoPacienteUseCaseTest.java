package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.commands.ActualizarTelefonoPaciente;
import co.com.reto.covid.domain.registrodepaciente.events.PacienteAgregado;
import co.com.reto.covid.domain.registrodepaciente.events.RegistroDePacienteCreado;
import co.com.reto.covid.domain.registrodepaciente.events.TelefonoDePacienteActualizado;
import co.com.reto.covid.domain.registrodepaciente.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarTelefonoPacienteUseCaseTest {

    private ActualizarTelefonoPacienteUseCase actualizarTelefonoPacienteUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarTelefonoPacienteUseCase = new ActualizarTelefonoPacienteUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarTelefonoPacienteUseCase.addRepository(repository);
    }

    @Test
    void actualizarTelefonoPacienteHappyPath(){
        //arrange
        var command = new ActualizarTelefonoPaciente(
                AdmisionId.of("1111"),
                IdentificacionPaciente.of("1064937422"),
                new Telefono("77788809")
        );
        when(repository.getEventsBy(any())).thenReturn(events());
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1111")
                .syncExecutor(
                        actualizarTelefonoPacienteUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        System.out.println(response);
        var evento = (TelefonoDePacienteActualizado)response.getDomainEvents().get(0);
        //assert
        Assertions.assertEquals("77788809",evento.getTelefono().value());
    }

    private List<DomainEvent> events() {
        return List.of(new RegistroDePacienteCreado(
                new Fecha(new Date(1990, 05, 20)))
                ,new PacienteAgregado(
                        new IdentificacionPaciente("1064937422"),
                        new TipoDeIdentificacion("RC"),
                        new Nombres("juan"),
                        new Telefono("3124168909"),
                        new Eps("mutual")
                ));
    }
}