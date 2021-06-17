package co.com.reto.covid.registroDePaciente;

import co.com.reto.covid.registroDePaciente.values.*;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Evolucion extends Entity <NumeroId>{

    protected Estado estado;
    protected Temperatura temperatura;
    protected SaturacionDeOxigeno saturacionDeOxigeno;
    protected FrecuenciaRespiratoria frecuenciaRespiratoria;
    protected Observacion observacion;

    public Evolucion(NumeroId numeroId,Estado estado,Temperatura temperatura,SaturacionDeOxigeno saturacionDeOxigeno,FrecuenciaRespiratoria frecuenciaRespiratoria, Observacion observacion) {
        super(numeroId);
        this.estado = estado;
        this.temperatura = temperatura;
        this.saturacionDeOxigeno = saturacionDeOxigeno;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.observacion = observacion;
    }

    public void actualizarEvolucion(Estado estado, Temperatura temperatura,SaturacionDeOxigeno saturacionDeOxigeno,FrecuenciaRespiratoria frecuenciaRespiratoria,Observacion observacion){
        this.estado = Objects.requireNonNull(estado);
        this.temperatura = Objects.requireNonNull(temperatura);
        this.saturacionDeOxigeno = Objects.requireNonNull(saturacionDeOxigeno);
        this.frecuenciaRespiratoria = Objects.requireNonNull(frecuenciaRespiratoria);
        this.observacion = Objects.requireNonNull(observacion);
    }

    public void actualizarEstadoPaciente(Estado estado){
        this.estado = Objects.requireNonNull(estado);
    }

    public void actualizarTemperaturaPaciente(Temperatura temperatura){
        this.temperatura = Objects.requireNonNull(temperatura);
    }

    public void actualizarSaturacionDeOxigeno(SaturacionDeOxigeno saturacionDeOxigeno){
        this.saturacionDeOxigeno = Objects.requireNonNull(saturacionDeOxigeno);
    }

    public void actualizarFrecuenciaRespiratoria(FrecuenciaRespiratoria frecuenciaRespiratoria){
        this.frecuenciaRespiratoria = Objects.requireNonNull(frecuenciaRespiratoria);
    }

    public void actualizarObservacion(Observacion observacion){
        this.observacion = Objects.requireNonNull(observacion);
    }

    public Estado Estado() {
        return estado;
    }

    public Temperatura Temperatura() {
        return temperatura;
    }

    public SaturacionDeOxigeno SaturacionDeOxigeno() {
        return saturacionDeOxigeno;
    }

    public FrecuenciaRespiratoria FrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public Observacion Observacion() {
        return observacion;
    }
}
