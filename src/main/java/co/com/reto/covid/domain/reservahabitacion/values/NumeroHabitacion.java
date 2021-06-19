package co.com.reto.covid.domain.reservahabitacion.values;

import co.com.sofka.domain.generic.Identity;


public class NumeroHabitacion extends Identity {

    public NumeroHabitacion(){

    }

    public NumeroHabitacion(String id){
        super(id);
    }

    public static NumeroHabitacion of(String id){
        return new NumeroHabitacion(id);
    }
}
