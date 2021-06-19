package co.com.reto.covid.usecases.reservahabitacion;

import co.com.reto.covid.domain.registrodepaciente.values.IdentificacionMedico;

public interface MedicoService {
    String getEmailAseguradora(IdentificacionMedico identificacionMedico);
}
