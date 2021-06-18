package co.com.reto.covid.domain.reservahabitacion.commands;

import co.com.reto.covid.domain.reservahabitacion.values.IdentificacionEmpleado;
import co.com.reto.covid.domain.reservahabitacion.values.NumeroReservaId;

public class AgregarAdmisionista {
    private final NumeroReservaId numeroReservaId;
    private final IdentificacionEmpleado identificacionEmpleado;

    public AgregarAdmisionista(NumeroReservaId numeroReservaId, IdentificacionEmpleado identificacionEmpleado) {
        this.numeroReservaId = numeroReservaId;
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public NumeroReservaId getNumeroReservaId() {
        return numeroReservaId;
    }

    public IdentificacionEmpleado getIdentificacionEmpleado() {
        return identificacionEmpleado;
    }
}
