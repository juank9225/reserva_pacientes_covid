package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeIdentificacion implements ValueObject<String> {
    private final String value;

    public TipoDeIdentificacion(String value) {
        this.value = Objects.requireNonNull(value, "el tipo de identificacion es requerido");
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("el tipo de identificacion no puede ser vacio");
        }
        if (this.value.length() <= 0 || this.value.length() > 2) {
            throw new IllegalArgumentException("el tipo de identificacion debe tener entre 1 y 2 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoDeIdentificacion that = (TipoDeIdentificacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
