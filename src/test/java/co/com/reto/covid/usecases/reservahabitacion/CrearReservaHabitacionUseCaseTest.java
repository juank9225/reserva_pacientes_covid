package co.com.reto.covid.usecases.reservahabitacion;


import co.com.reto.covid.domain.registrodepaciente.values.Estado;
import co.com.reto.covid.domain.registrodepaciente.values.Fecha;
import co.com.reto.covid.domain.registrodepaciente.values.Hora;
import co.com.reto.covid.domain.reservahabitacion.commands.CrearReservaHabitacion;
import co.com.reto.covid.domain.reservahabitacion.events.ReservaHabitacionAgregada;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearReservaHabitacionUseCaseTest {

    private CrearReservaHabitacionUseCase crearReservaHabitacionUseCase;

    @BeforeEach
    public void setup(){
        crearReservaHabitacionUseCase = new CrearReservaHabitacionUseCase();
    }

    @Test
    void crearReservaHabitacionHappyPath(){
        //arrange
        var command = new CrearReservaHabitacion(
                NumeroReservaId.of("5555"),
                new Fecha(new Date(1990,05,20)),
                new Hora("05:00 pm"),
                new Estado("no registra pago")
        );
        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                crearReservaHabitacionUseCase,new RequestCommand<>(command))
                .orElseThrow();

        var event = response.getDomainEvents();

        //assert
        ReservaHabitacionAgregada reservaCreada = (ReservaHabitacionAgregada) event.get(0);
        Assertions.assertEquals(1990,reservaCreada.getFecha().value().getYear());
        Assertions.assertEquals(05,reservaCreada.getFecha().value().getMonth());
        Assertions.assertEquals("05:00 pm",reservaCreada.getHora().value());
        Assertions.assertEquals("no registra pago",reservaCreada.getEstado().value());
    }
}