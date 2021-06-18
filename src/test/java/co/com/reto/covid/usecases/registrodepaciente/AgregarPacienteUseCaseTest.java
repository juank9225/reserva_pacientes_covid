package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.commands.AgregarPaciente;
import co.com.reto.covid.domain.registrodepaciente.events.RegistroDePacienteCreado;
import co.com.reto.covid.domain.registrodepaciente.values.*;
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

class AgregarPacienteUseCaseTest {

    private AgregarPacienteUseCase agregarPacienteUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        agregarPacienteUseCase = new AgregarPacienteUseCase();
        repository = mock(DomainEventRepository.class);
        agregarPacienteUseCase.addRepository(repository);
    }

    @Test
    void agregaPacienteUseCaseHappyPath(){
        //arrage
        var command = new AgregarPaciente(
                AdmisionId.of("1111"),
                new IdentificacionPaciente("1064937422"),
                new TipoDeIdentificacion("RC"),
                new Nombres("juan"),
                new Telefono("3124168909"),
                new Eps("mutual")
        );
        when(repository.getEventsBy(any())).thenReturn(events());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1111")
                .syncExecutor(
                        agregarPacienteUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        System.out.println(response);

    }

    private List<DomainEvent> events() {
        return List.of(new RegistroDePacienteCreado(
                new Fecha(new Date(1990,05,20))
        ));
    }

}