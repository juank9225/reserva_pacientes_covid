package co.com.reto.covid.registroDePaciente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FrecuenciaRespiratoria implements ValueObject<Integer> {
    private final Integer value;

    public FrecuenciaRespiratoria(Integer value) {
        this.value = Objects.requireNonNull(value,"la frecuencia respiratoria es requerida");
        if (this.value<=0 || this.value > 100){
            throw new IllegalArgumentException("la frecuencia respiratoria debe estar entre 0 y 100");
        }
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrecuenciaRespiratoria that = (FrecuenciaRespiratoria) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
