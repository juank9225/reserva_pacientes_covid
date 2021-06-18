package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.commands.ActualizarRegistroMedico;
import co.com.reto.covid.domain.registrodepaciente.commands.ActualizarTelefonoPaciente;
import co.com.reto.covid.domain.registrodepaciente.events.*;
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

class ActualizarRegistroMedicoUseCaseTest {

    private ActualizarRegistroMedicoUseCase actualizarRegistroMedicoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        actualizarRegistroMedicoUseCase = new ActualizarRegistroMedicoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarRegistroMedicoUseCase.addRepository(repository);
    }
    @Test
    void actualizarRegistroMedicoHappyPath(){
        //arrange
        var command = new ActualizarRegistroMedico(
                AdmisionId.of("1111"),
                IdentificacionMedico.of("987654321"),
                new RegistroMedico("7001/04")
        );
        when(repository.getEventsBy(any())).thenReturn(events());
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1111")
                .syncExecutor(
                        actualizarRegistroMedicoUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();

        var evento = (RegistroMedicoActualizado)response.getDomainEvents().get(0);

        //assert
        Assertions.assertEquals("7001/04",evento.getRegistroMedico().value());
    }

    private List<DomainEvent> events() {
        return List.of(new RegistroDePacienteCreado(
                new Fecha(new Date(1990,05,20))
        ),new MedicoAgregado(
                new IdentificacionMedico("987654321"),
                new TipoDeIdentificacion("RC"),
                new Nombres("Ivan"),
                new Telefono("77789321"),
                new RegistroMedico("0098/01"),
                new Especialidad("Pediatria")
        ));
    }
}