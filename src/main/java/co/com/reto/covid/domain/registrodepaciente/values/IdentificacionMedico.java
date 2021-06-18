package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.Identity;

public class IdentificacionMedico extends Identity {

    public IdentificacionMedico(){

    }

    public IdentificacionMedico(String id){
        super(id);
    }

    public static IdentificacionMedico of(String id){
        return new IdentificacionMedico(id);
    }

}
