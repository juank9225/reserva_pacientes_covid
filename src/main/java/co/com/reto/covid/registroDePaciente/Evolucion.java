package co.com.reto.covid.registroDePaciente;

import co.com.reto.covid.registroDePaciente.values.NumeroId;
import co.com.sofka.domain.generic.Entity;

public class Evolucion extends Entity <NumeroId>{

    public Evolucion(NumeroId entityId) {
        super(entityId);
    }
}
