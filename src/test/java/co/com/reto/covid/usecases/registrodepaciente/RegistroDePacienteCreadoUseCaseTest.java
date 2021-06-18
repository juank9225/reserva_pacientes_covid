package co.com.reto.covid.usecases.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.commands.CrearRegistroDePaciente;
import co.com.reto.covid.domain.registrodepaciente.events.RegistroDePacienteCreado;
import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.Fecha;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RegistroDePacienteCreadoUseCaseTest {

    private RegistroDePacienteCreadoUseCase registroDePacienteCreadoUseCase;

    @BeforeEach
    public void setup(){
        registroDePacienteCreadoUseCase = new RegistroDePacienteCreadoUseCase();
    }
    @Test
    void registroPacienteHappyPath(){
        //arrange
        var command = new CrearRegistroDePaciente(
                AdmisionId.of("1111"),
                new Fecha(new Date(1990,05,20))
        );

        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                registroDePacienteCreadoUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var event = response.getDomainEvents();

        //assert
        RegistroDePacienteCreado registroDePacienteCreado = (RegistroDePacienteCreado) event.get(0);
        Assertions.assertEquals(1990,registroDePacienteCreado.getFecha().value().getYear());
        Assertions.assertEquals(05,registroDePacienteCreado.getFecha().value().getMonth());
    }

}