package co.com.reto.covid.domain.registrodepaciente.values;


import co.com.sofka.domain.generic.Identity;

public class IdentificacionPaciente extends Identity {

    public IdentificacionPaciente(){

    }

    private IdentificacionPaciente(String id){
        super(id);
    }

    public static IdentificacionPaciente of(String id){
        return new IdentificacionPaciente(id);
    }

}
