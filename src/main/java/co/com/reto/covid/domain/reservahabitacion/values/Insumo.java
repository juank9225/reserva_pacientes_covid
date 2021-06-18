package co.com.reto.covid.domain.reservahabitacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Insumo implements ValueObject<String> {
    private final String value;

    public Insumo(String value) {
        this.value = Objects.requireNonNull(value,"el insumo es requerido");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("el insumo no puede ser vacio");
        }
        if (this.value.length() < 2 || this.value.length() >= 50){
            throw new IllegalArgumentException("el nombre del insumo debe terner mas de 1 caracter y menos de 50 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumo insumo = (Insumo) o;
        return Objects.equals(value, insumo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
