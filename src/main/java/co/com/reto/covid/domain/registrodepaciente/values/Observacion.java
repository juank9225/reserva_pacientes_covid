package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Observacion implements ValueObject<String> {
    private final String value;

    public Observacion(String value) {
        this.value = Objects.requireNonNull(value, "la observacion es requerida");
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("la observacion no puede ser vacia");
        }
        if (this.value.length() < 10 || this.value.length() > 250) {
            throw new IllegalArgumentException("la observacion debe tener entre 10 y 250 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observacion that = (Observacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
