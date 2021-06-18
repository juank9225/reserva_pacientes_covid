package co.com.reto.covid.reservaHabitacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Medicamento implements ValueObject<String> {
    private final String value;

    public Medicamento(String value) {
        this.value = Objects.requireNonNull(value,"el medicamento es requerido");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("el medicamento no puede ser vacio");
        }
        if (this.value.length() < 2 || this.value.length() >= 50){
            throw new IllegalArgumentException("el nombre del medicamento debe terner mas de 1 caracter y menos de 50 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicamento that = (Medicamento) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
