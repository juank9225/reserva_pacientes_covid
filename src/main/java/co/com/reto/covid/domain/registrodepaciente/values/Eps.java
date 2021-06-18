package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Eps implements ValueObject<String> {
    private final String value;

    public Eps(String value) {
        this.value = Objects.requireNonNull(value,"la EPS es requerida");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("la EPS no pueder ser vacia");
        }
        if (this.value.length() <=3 || this.value.length() >=50){
            throw new IllegalArgumentException("la EPS debe tener entre 4 caracteres y 50 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eps eps = (Eps) o;
        return Objects.equals(value, eps.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
