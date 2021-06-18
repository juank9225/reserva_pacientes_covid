package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.commands.AgregarMedico;
import co.com.reto.covid.domain.registrodepaciente.commands.AgregarPaciente;
import co.com.reto.covid.domain.registrodepaciente.events.PacienteAgregado;
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

class AgregarMedicoUseCaseTest {

    private AgregarMedicoUseCase agregarMedicoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        agregarMedicoUseCase = new AgregarMedicoUseCase();
        repository = mock(DomainEventRepository.class);
        agregarMedicoUseCase.addRepository(repository);
    }

    @Test
    void agregarMedicoUseCaseHappyPath(){
        //arrage
        var command = new AgregarMedico(
                AdmisionId.of("1111"),
                new IdentificacionMedico("987654321"),
                new TipoDeIdentificacion("RC"),
                new Nombres("Ivan"),
                new Telefono("77789321"),
                new RegistroMedico("0098/01"),
                new Especialidad("Pediatria")
        );
        when(repository.getEventsBy(any())).thenReturn(events());
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1111")
                .syncExecutor(
                        agregarMedicoUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        System.out.println(response);
    }

    private List<DomainEvent> events() {
        return List.of(new RegistroDePacienteCreado(
                new Fecha(new Date(1990,05,20))
        ),new PacienteAgregado(
                new IdentificacionPaciente("1064937422"),
                new TipoDeIdentificacion("RC"),
                new Nombres("juan"),
                new Telefono("3124168909"),
                new Eps("mutual")
        ));
    }
}