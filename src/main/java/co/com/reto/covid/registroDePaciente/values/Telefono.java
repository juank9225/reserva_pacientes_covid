package co.com.reto.covid.registroDePaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {
    private final String value;

    public Telefono(String value) {
        this.value = Objects.requireNonNull(value,"el telefono es obligatorio");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("el telefono no puede ser vacia");
        }
        if (this.value.length() < 7 || this.value.length() >10){
            throw new IllegalArgumentException("el telefono debe tener entre 7 y 10 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(value, telefono.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
