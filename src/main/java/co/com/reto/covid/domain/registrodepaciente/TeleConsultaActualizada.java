package co.com.reto.covid.domain.registrodepaciente;

import co.com.reto.covid.domain.registrodepaciente.values.Fecha;
import co.com.reto.covid.domain.registrodepaciente.values.Hora;
import co.com.reto.covid.domain.registrodepaciente.values.RadicadoId;
import co.com.reto.covid.domain.registrodepaciente.values.Satisfaccion;
import co.com.sofka.domain.generic.DomainEvent;

public class TeleConsultaActualizada extends DomainEvent {
    private final RadicadoId radicadoId;
    private final Fecha fecha;
    private final Hora hora;
    private final Satisfaccion satisfaccion;

    public TeleConsultaActualizada(RadicadoId radicadoId, Fecha fecha, Hora hora, Satisfaccion satisfaccion) {
        super("sofka.registropersona.teleconsultaactualizada");
        this.radicadoId = radicadoId;
        this.fecha = fecha;
        this.hora = hora;
        this.satisfaccion = satisfaccion;
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
