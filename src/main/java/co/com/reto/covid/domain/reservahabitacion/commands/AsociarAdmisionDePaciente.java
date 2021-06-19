package co.com.reto.covid.domain.reservahabitacion.commands;

import co.com.reto.covid.domain.registrodepaciente.values.AdmisionId;
import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;
import co.com.sofka.domain.generic.Command;

public class AsociarAdmisionDePaciente implements Command {
    private NumeroReservaId numeroReservaId;
    private AdmisionId admisionId;
    private IdentificacionMedico identificacionMedico;


    public AsociarAdmisionDePaciente(NumeroReservaId numeroReservaId, AdmisionId admisionId) {
        this.numeroReservaId = numeroReservaId;
        this.admisionId = admisionId;
    }

    public NumeroReservaId getNumeroReservaId() {
        return numeroReservaId;
    }

    public AdmisionId getAdmisionId() {
        return admisionId;
    }

    public IdentificacionMedico getIdentificacionMedico() {
        return identificacionMedico;
    }
}
