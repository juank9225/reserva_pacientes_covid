package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;

public interface ServiceQuery {
    String getEmailMedicoId(IdentificacionMedico medicoId);
}
