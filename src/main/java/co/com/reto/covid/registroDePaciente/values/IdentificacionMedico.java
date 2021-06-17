package co.com.reto.covid.registroDePaciente.values;

import co.com.sofka.domain.generic.Identity;

public class IdentificacionMedico extends Identity {

    public IdentificacionMedico(){

    }

    private IdentificacionMedico(String id){
        super(id);
    }

    public static IdentificacionMedico of(String id){
        return new IdentificacionMedico(id);
    }

}
