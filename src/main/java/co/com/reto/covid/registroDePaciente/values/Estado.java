package co.com.reto.covid.registroDePaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado implements ValueObject<String> {

    private final String value;

    public Estado(String value) {
        this.value = Objects.requireNonNull(value,"el estado es obligatorio");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("el estado no puede ser vacio");
        }
        if (this.value.length() <= 6 || this.value.length() >= 11){
            throw new IllegalArgumentException("el estado debe terner mas de 5 caracteres y menos de 11 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(value, estado.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
