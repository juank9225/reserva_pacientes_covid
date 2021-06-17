package co.com.reto.covid.registroDePaciente;

import co.com.reto.covid.registroDePaciente.values.Fecha;
import co.com.reto.covid.registroDePaciente.values.Hora;
import co.com.reto.covid.registroDePaciente.values.RadicadoId;
import co.com.reto.covid.registroDePaciente.values.Satisfaccion;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class TeleConsulta extends Entity<RadicadoId> {

    protected Fecha fecha;
    protected Hora hora;
    protected Satisfaccion satisfaccion;

    public TeleConsulta(RadicadoId radicadoId, Fecha fecha, Hora hora, Satisfaccion satisfaccion) {
        super(radicadoId);
        this.fecha = fecha;
        this.hora = hora;
        this.satisfaccion = satisfaccion;
    }

    public void actualizarFechaTeleConsulta(Fecha fecha){
        this.fecha = Objects.requireNonNull(fecha);
    }

    public void actualizarHoraTeleConsulta(Hora hora){
        this.hora = Objects.requireNonNull(hora);
    }

    public void actualizarSatisFaccionTeleConsulta(Satisfaccion satisfaccion){
        this.satisfaccion = Objects.requireNonNull(satisfaccion);
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Hora Hora() {
        return hora;
    }

    public Satisfaccion Satisfaccion() {
        return satisfaccion;
    }
}
