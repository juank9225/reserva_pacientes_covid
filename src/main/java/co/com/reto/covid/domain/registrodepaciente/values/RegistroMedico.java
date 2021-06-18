package co.com.reto.covid.domain.registrodepaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RegistroMedico implements ValueObject<String> {
    private final String value;

    public RegistroMedico(String value) {
        this.value = Objects.requireNonNull(value,"el registro medico es requerido");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("el registro medico no puede ser vacio");
        }
        if (this.value.length() < 4 || this.value.length() > 10){
            throw new IllegalArgumentException("el registro debe terner mas de 3 caracteres y menos de 11 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroMedico that = (RegistroMedico) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
