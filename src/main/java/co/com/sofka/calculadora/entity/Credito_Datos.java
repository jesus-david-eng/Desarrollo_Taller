package co.com.sofka.calculadora.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Credito_Datos {
    private Integer periodo;
    private Double interes;
    private Double amortizacionCapital;
    private Double cuota;
    private Double capitaPendiente;

}
