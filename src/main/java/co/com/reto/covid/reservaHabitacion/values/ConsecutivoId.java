package co.com.reto.covid.reservaHabitacion.values;

import co.com.sofka.domain.generic.Identity;

public class ConsecutivoId extends Identity {
    public ConsecutivoId(){

    }

    private ConsecutivoId(String id){
        super(id);
    }

    public static ConsecutivoId of(String id){
        return new ConsecutivoId(id);
    }
}
