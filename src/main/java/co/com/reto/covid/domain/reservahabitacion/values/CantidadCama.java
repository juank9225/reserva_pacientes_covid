package co.com.reto.covid.domain.reservahabitacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CantidadCama implements ValueObject<Integer> {
    private final Integer value;

    public CantidadCama(Integer value) {
        this.value = Objects.requireNonNull(value,"la cantidad de camas  es requerida");
        if (this.value<=0 || this.value > 10){
            throw new IllegalArgumentException("la cantidad de camas debe estar entre 1 y 10");
        }
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CantidadCama that = (CantidadCama) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
