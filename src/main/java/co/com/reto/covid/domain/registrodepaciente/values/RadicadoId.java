package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.Identity;

public class RadicadoId extends Identity {

    public RadicadoId(){

    }

    private RadicadoId(String id){
        super(id);
    }

    public static RadicadoId of(String id){
        return new RadicadoId(id);
    }

}
