package co.com.reto.covid.reservaHabitacion;

import co.com.reto.covid.registroDePaciente.values.AdmisionId;
import co.com.reto.covid.registroDePaciente.values.Estado;
import co.com.reto.covid.registroDePaciente.values.Fecha;
import co.com.reto.covid.registroDePaciente.values.Hora;
import co.com.reto.covid.reservaHabitacion.events.*;
import co.com.reto.covid.reservaHabitacion.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;
import java.util.Set;

public class ReservaHabitacion extends AggregateEvent<NumeroReservaId> {

    protected Fecha fecha;
    protected Hora hora;
    protected AdmisionId admisionId;
    protected IdentificacionEmpleado identificacionEmpleado;
    protected Set<Habitacion> habitaciones;
    protected Set<Botiquin> botiquines;
    protected Estado estado;

    public ReservaHabitacion(NumeroReservaId numeroReservaId,Fecha fecha, Hora hora,Estado estado) {
        super(numeroReservaId);
        appendChange(new ReservaHabitacionAgregada(fecha,hora,estado)).apply();

    }

    public void asociarAdmisionDePaciente(AdmisionId admisionId){
        appendChange(new AdmisionAsociada(admisionId)).apply();
    }

    public void agregarAdmisionista(IdentificacionEmpleado identificacionEmpleado){
        appendChange(new AdmisionistaAgregado(identificacionEmpleado)).apply();
    }

    public void agregarHabitacion(NumeroHabitacion numeroHabitacion, Tipo tipo, Estado estado, CantidadCama cantidadCama){
        Objects.requireNonNull(numeroHabitacion);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(estado);
        Objects.requireNonNull(cantidadCama);
        appendChange(new HabitacionAgregada(numeroHabitacion,tipo,estado,cantidadCama)).apply();
    }

    public void agregarBotiquin(ConsecutivoId consecutivoId,Tipo tipo,Medicamento medicamento,Insumo insumo){
        Objects.requireNonNull(consecutivoId);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(medicamento);
        Objects.requireNonNull(insumo);
        appendChange(new BotiquinAgregado(consecutivoId,tipo,medicamento,insumo)).apply();
    }

    public void actualizarHabitacionDePaciente(Estado estado,CantidadCama cantidadCama){
        appendChange(new HabitacionDePacienteActualizada(estado,cantidadCama)).apply();
    }

}