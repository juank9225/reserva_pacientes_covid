package co.com.reto.covid.reservaHabitacion.values;

import co.com.reto.covid.registroDePaciente.values.IdentificacionPaciente;
import co.com.sofka.domain.generic.Identity;


public class NumeroHabitacion extends Identity {

    public NumeroHabitacion(){

    }

    private NumeroHabitacion(String id){
        super(id);
    }

    public static NumeroHabitacion of(String id){
        return new NumeroHabitacion(id);
    }
}
