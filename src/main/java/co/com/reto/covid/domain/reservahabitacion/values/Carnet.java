package co.com.reto.covid.domain.reservahabitacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Carnet implements ValueObject<String> {
    private final String value;

    public Carnet(String value) {
        this.value = Objects.requireNonNull(value,"el serial de carnet es requerido");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("el serial del carnet no puede ser vacio");
        }
        if (this.value.length() < 2 || this.value.length() >= 50){
            throw new IllegalArgumentException("el serial del carnet debe terner mas de 1 caracter y menos de 50 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carnet carnet = (Carnet) o;
        return Objects.equals(value, carnet.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
