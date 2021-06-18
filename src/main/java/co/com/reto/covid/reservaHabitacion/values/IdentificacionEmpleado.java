package co.com.reto.covid.reservaHabitacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdentificacionEmpleado extends Identity {
    public IdentificacionEmpleado(){

    }

    private IdentificacionEmpleado(String id){
        super(id);
    }

    public static IdentificacionEmpleado of(String id){
        return new IdentificacionEmpleado(id);
    }
}
