package co.com.reto.covid.reservaHabitacion.values;

import co.com.sofka.domain.generic.Identity;

public class NumeroReservaId extends Identity {

    public NumeroReservaId(){

    }

    private NumeroReservaId(String id){
        super(id);
    }

    public static NumeroReservaId of(String id){
        return new NumeroReservaId(id);
    }
}
