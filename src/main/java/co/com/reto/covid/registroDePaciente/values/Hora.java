package co.com.reto.covid.registroDePaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Hora implements ValueObject<String> {
    private final String value;

    public Hora(String value) {
        this.value = Objects.requireNonNull(value,"la hora es requerida");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("la hora no puede ser vacia");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hora hora = (Hora) o;
        return Objects.equals(value, hora.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
