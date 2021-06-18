package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Temperatura implements ValueObject<Double> {
    private final Double value;

    public Temperatura(Double value) {
        this.value = Objects.requireNonNull(value,"la temperatura es obligatoria");
        if (this.value <= 0 ||this.value > 100){
            throw new IllegalArgumentException("la temperatura debe ser entre 0 y 100");
        }
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperatura that = (Temperatura) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
