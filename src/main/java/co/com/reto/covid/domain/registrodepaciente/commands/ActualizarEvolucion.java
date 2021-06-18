package co.com.reto.covid.domain.registrodepaciente.commands;

import co.com.reto.covid.domain.registrodepaciente.values.*;
import co.com.sofka.domain.generic.Command;

public class ActualizarEvolucion implements Command {

    private final AdmisionId admisionId;
    private final NumeroId numeroId;
    private final Estado estado;
    private final Temperatura temperatura;
    private final SaturacionDeOxigeno saturacionDeOxigeno;
    private final FrecuenciaRespiratoria frecuenciaRespiratoria;
    private final Observacion observacion;

    public ActualizarEvolucion(AdmisionId admisionId, NumeroId numeroId, Estado estado, Temperatura temperatura, SaturacionDeOxigeno saturacionDeOxigeno, FrecuenciaRespiratoria frecuenciaRespiratoria, Observacion observacion) {
        this.admisionId = admisionId;
        this.numeroId = numeroId;
        this.estado = estado;
        this.temperatura = temperatura;
        this.saturacionDeOxigeno = saturacionDeOxigeno;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.observacion = observacion;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public NumeroId getNumeroId() {
        return numeroId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public SaturacionDeOxigeno getSaturacionDeOxigeno() {
        return saturacionDeOxigeno;
    }

    public FrecuenciaRespiratoria getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
