package co.com.reto.covid.registroDePaciente.values;

import co.com.sofka.domain.generic.Identity;

public class Radicado extends Identity {

    public Radicado(){

    }

    private Radicado(String id){
        super(id);
    }

    public static Radicado of(String id){
        return new Radicado(id);
    }

}
