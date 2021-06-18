package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especialidad implements ValueObject<String> {
    private final String value;

    public Especialidad(String value) {
        this.value = Objects.requireNonNull(value,"la especialidad es requerida");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("la especialidad no puede ser vacia");
        }
        if (this.value.length() < 2 || this.value.length() >= 50){
            throw new IllegalArgumentException("la especialidad debe terner mas de 1 caracter y menos de 50 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especialidad that = (Especialidad) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
