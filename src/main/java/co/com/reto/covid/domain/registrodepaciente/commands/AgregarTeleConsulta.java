package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarTeleConsulta implements Command {
    private final AdmisionId admisionId;
    private final RadicadoId radicadoId;
    private final Fecha fecha;
    private final Hora hora;
    private final Satisfaccion satisfaccion;

    public AgregarTeleConsulta(AdmisionId admisionId, RadicadoId radicadoId, Fecha fecha, Hora hora, Satisfaccion satisfaccion) {
        this.admisionId = admisionId;
        this.radicadoId = radicadoId;
        this.fecha = fecha;
        this.hora = hora;
        this.satisfaccion = satisfaccion;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public RadicadoId getRadicadoId() {
        return radicadoId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Hora getHora() {
        return hora;
    }

    public Satisfaccion getSatisfaccion() {
        return satisfaccion;
    }
}
