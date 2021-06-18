package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombres implements ValueObject<String> {
    private final String value;

    public Nombres(String value) {
        this.value = Objects.requireNonNull(value,"el nombre es requerido");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("el nombre no puede ser vacio");
        }
        if (this.value.length() < 3 || this.value.length() >= 50){
            throw new IllegalArgumentException("el nombre debe terner mas de 2 caracteres y menos de 50 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombres nombres = (Nombres) o;
        return Objects.equals(value, nombres.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
