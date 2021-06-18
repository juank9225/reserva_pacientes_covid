package co.com.reto.covid.domain.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.values.Nombres;
import co.com.reto.covid.domain.registrodepaciente.values.Telefono;
import co.com.reto.covid.domain.registrodepaciente.values.TipoDeIdentificacion;
import co.com.reto.covid.domain.reservahabitacion.values.Carnet;
import co.com.reto.covid.domain.reservahabitacion.values.IdentificacionEmpleado;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Empleado extends Entity<IdentificacionEmpleado> {

    protected TipoDeIdentificacion tipoDeIdentificacion;
    protected Nombres nombres;
    protected Telefono telefono;
    protected Carnet carnet;

    public Empleado(IdentificacionEmpleado identificacionEmpleado,TipoDeIdentificacion tipoDeIdentificacion,Nombres nombres,Telefono telefono,Carnet carnet) {
        super(identificacionEmpleado);
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.nombres = nombres;
        this.telefono = telefono;
        this.carnet = carnet;
    }

    public void actualizarEmpleado(Nombres nombres,Telefono telefono,Carnet carnet){
        this.nombres = Objects.requireNonNull(nombres);
        this.telefono = Objects.requireNonNull(telefono);
        this.carnet = Objects.requireNonNull(carnet);
    }

    public void actualizarNombreEmpleado(Nombres nombres){
        this.nombres = Objects.requireNonNull(nombres);
    }

    public TipoDeIdentificacion TipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public Nombres Nombres() {
        return nombres;
    }

    public Telefono Telefono() {
        return telefono;
    }

    public Carnet Carnet() {
        return carnet;
    }
}
