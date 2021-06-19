package co.com.reto.covid.domain.reservahabitacion;

import co.com.reto.covid.domain.reservahabitacion.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class ReservaHabitacionChange extends EventChange {

    public ReservaHabitacionChange(ReservaHabitacion reservaHabitacion) {

        apply((ReservaHabitacionAgregada event) -> {
            reservaHabitacion.fecha = event.getFecha();
            reservaHabitacion.hora = event.getHora();
            reservaHabitacion.estado = event.getEstado();
            reservaHabitacion.habitaciones = new HashSet<>();
            reservaHabitacion.botiquines = new HashSet<>();
        });

        apply((AdmisionAsociada event) -> {
            reservaHabitacion.admisionId = event.getAdmisionId();
        });

        apply((AdmisionistaAgregado event) -> {
            reservaHabitacion.identificacionEmpleado = event.getIdentificacionEmpleado();
        });

        apply((HabitacionAgregada event) -> {
            reservaHabitacion.habitaciones.add(new Habitacion(
                    event.getNumeroHabitacion(),
                    event.getTipo(),
                    event.getEstado(),
                    event.getCantidadCama()
            ));
        });

        apply((BotiquinAgregado event) -> {
            reservaHabitacion.botiquines.add(new Botiquin(
                    event.getConsecutivoId(),
                    event.getTipo(),
                    event.getMedicamento(),
                    event.getInsumo()
            ));
        });

        apply((EstadoDeHabitacionDePacienteActualizada event) -> {
            var habitacion = reservaHabitacion.getHabitacionPorId(event.getNumeroHabitacion())
                    .orElseThrow(() -> new IllegalArgumentException("no se encontro el registro"));
            habitacion.actualizarEstadoHabitacion(event.getEstado());
        });

        apply((HabitacionDePacienteActualizada event) -> {
            var habitacion = reservaHabitacion.getHabitacionPorId(event.getNumeroHabitacion())
                    .orElseThrow(() -> new IllegalArgumentException("no se encontro el registro"));
            habitacion.actualizarHabitacion(event.getEstado(), event.getCantidadCama());
        });
    }
}
