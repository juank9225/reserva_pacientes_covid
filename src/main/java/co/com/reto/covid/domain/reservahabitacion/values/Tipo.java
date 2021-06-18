package co.com.reto.covid.domain.reservahabitacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<String> {
    private final String value;

    public Tipo(String value) {
        this.value = Objects.requireNonNull(value,"el tipo de habitacion es requerido");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("el tipo de habitacion no puede ser vacio");
        }
        if (this.value.length() < 2 || this.value.length() >= 50){
            throw new IllegalArgumentException("el tipo de habitacion debe terner mas de 1 caracter y menos de 50 caracteres");
        }
    }

    public String value() {
        return value;
    }
}
