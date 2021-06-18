package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Satisfaccion implements ValueObject <Integer>{
    private final Integer value;

    public Satisfaccion(Integer value) {
        this.value = Objects.requireNonNull(value,"la satisfaccion es requerida");
        if (this.value<=0 || this.value > 10){
            throw new IllegalArgumentException("la satisfaccion debe estar entre 1 y 10");
        }
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Satisfaccion that = (Satisfaccion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
