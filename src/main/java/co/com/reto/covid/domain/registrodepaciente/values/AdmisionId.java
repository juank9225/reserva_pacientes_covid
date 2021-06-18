package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.Identity;

public class AdmisionId extends Identity {

    public AdmisionId(){

    }

    private AdmisionId(String id){
        super(id);
    }

    public static AdmisionId of(String id){
        return new AdmisionId(id);
    }
}
