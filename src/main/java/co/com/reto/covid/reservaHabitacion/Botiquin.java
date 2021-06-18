package co.com.reto.covid.reservaHabitacion;

import co.com.reto.covid.reservaHabitacion.values.ConsecutivoId;
import co.com.reto.covid.reservaHabitacion.values.Insumo;
import co.com.reto.covid.reservaHabitacion.values.Medicamento;
import co.com.reto.covid.reservaHabitacion.values.Tipo;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Botiquin extends Entity<ConsecutivoId> {

    protected Tipo tipo;
    protected Medicamento medicamento;
    protected Insumo insumo;

    public Botiquin(ConsecutivoId consecutivoId,Tipo tipo,Medicamento medicamento, Insumo insumo) {
        super(consecutivoId);
        this.tipo = tipo;
        this.medicamento = medicamento;
        this.insumo = insumo;
    }

    public void actualizarMedicamento(Medicamento medicamento){
        this.medicamento = Objects.requireNonNull(medicamento);
    }

    public void actualizarInsumo(Insumo insumo){
        this.insumo = Objects.requireNonNull(insumo);
    }

    public Tipo Tipo() {
        return tipo;
    }

    public Medicamento Medicamento() {
        return medicamento;
    }

    public Insumo Insumo() {
        return insumo;
    }
}
