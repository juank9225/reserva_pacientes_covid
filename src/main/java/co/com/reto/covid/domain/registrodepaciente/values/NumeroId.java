package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.Identity;

public class NumeroId extends Identity {
    public NumeroId(){

    }

    public NumeroId(String id){
        super(id);
    }

    public static NumeroId of(String id){
        return new NumeroId(id);
    }
}
