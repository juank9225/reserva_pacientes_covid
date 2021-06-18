package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.commands.AgregarEvolucion;
import co.com.reto.covid.domain.registrodepaciente.commands.AgregarTeleConsulta;
import co.com.reto.covid.domain.registrodepaciente.events.EvolucionAgregada;
import co.com.reto.covid.domain.registrodepaciente.events.MedicoAgregado;
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

class AgregarTeleConsultaUseCaseTest {

    private AgregarTeleConsultaUseCase agregarTeleConsultaUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        agregarTeleConsultaUseCase = new AgregarTeleConsultaUseCase();
        repository = mock(DomainEventRepository.class);
        agregarTeleConsultaUseCase.addRepository(repository);
    }

    @Test
    void agregarEvolucionUseCaseHappyPath(){
        //arrage
        var command = new AgregarTeleConsulta(
                AdmisionId.of("1111"),
                new RadicadoId("90008765"),
                new Fecha(new Date(1990,05,20)),
                new Hora("03:50 pm"),
                new Satisfaccion(10)
        );

        when(repository.getEventsBy(any())).thenReturn(events());
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1111")
                .syncExecutor(
                        agregarTeleConsultaUseCase,
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
        ),new MedicoAgregado(
                new IdentificacionMedico("987654321"),
                new TipoDeIdentificacion("RC"),
                new Nombres("Ivan"),
                new Telefono("77789321"),
                new RegistroMedico("0098/01"),
                new Especialidad("Pediatria")
        ),new EvolucionAgregada(
                new NumeroId("2550"),
                new Estado("en recuperacion"),
                new Temperatura(35.6),
                new SaturacionDeOxigeno(97),
                new FrecuenciaRespiratoria(80),
                new Observacion("se encuentra paciente en estado de recupercion por covid 19")));
    }
}