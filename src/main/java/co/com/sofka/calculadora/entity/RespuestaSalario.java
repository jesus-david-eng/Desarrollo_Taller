package co.com.sofka.calculadora.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)

public class RespuestaSalario {
    private final Double salarioBase;
    private final double aporteSaludEmpleado;
    private final double aporteSaludEmpleador;
    private final double aportePensionEmpleado;
    private final double aportePensionEmpleador;
    private final double aporteRiesgosLaborales;
    private final Double aporteCajaDeCompensacion;
    private final double aporteFSP;
    private final double pagoNetoEmpleado;
    private final double costoEmpleador;
}
