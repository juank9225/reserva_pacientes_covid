package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.registrodepaciente.values.Fecha;
import co.com.reto.covid.domain.registrodepaciente.values.Hora;
import co.com.reto.covid.domain.reservahabitacion.commands.ActualizarMedicamento;
import co.com.reto.covid.domain.reservahabitacion.events.*;
import co.com.reto.covid.domain.reservahabitacion.values.*;
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

class ActualizarMedicamentoUseCaseTest {

    private ActualizarMedicamentoUseCase actualizarMedicamentoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarMedicamentoUseCase = new ActualizarMedicamentoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarMedicamentoUseCase.addRepository(repository);
    }

    @Test
    void actualizarMedicamentoUseCaseHappyPath() {

        var command = new ActualizarMedicamento(
                NumeroReservaId.of("5555"),
                ConsecutivoId.of("01"),
                new Medicamento("Aspirina")
        );
        when(repository.getEventsBy(any())).thenReturn(events());
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("5555")
                .syncExecutor(
                        actualizarMedicamentoUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (MedicamentoActualizado) response.getDomainEvents().get(0);

        Assertions.assertEquals("Aspirina", evento.getMedicamento().value());
    }

    private List<DomainEvent> events() {
        return List.of(new ReservaHabitacionAgregada(
                new Fecha(new Date(1990, 05, 20)),
                new Hora("05:00 pm"),
                new Estado("no registra pago")
        ), new AdmisionAsociada(
                new AdmisionId("1111")
        ), new HabitacionAgregada(
                new NumeroHabitacion("21"),
                new Tipo("empresarial"),
                new Estado("aseada y en exelemte estado"),
                new CantidadCama(1)
        ), new BotiquinAgregado(
                new ConsecutivoId("02"),
                new Tipo("Pacientes covid 19"),
                new Medicamento("Corticoides"),
                new Insumo("caja de tapa bocas")
        ));
    }
}