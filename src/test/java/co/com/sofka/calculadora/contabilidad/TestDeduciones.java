package co.com.sofka.calculadora.contabilidad;

import co.com.sofka.calculadora.Operaciones.Operacion_Deducciones;
import co.com.sofka.calculadora.entity.RespuestaSalario;
import org.junit.Assert;
import org.junit.Test;

public class TestDeduciones {

    private final double salarioBase = 1000000;


    @Test
    public void deducirTest() {
        double value = 100;
        double deduction = 0.04;
        double result = 4.0;
        Assert.assertEquals(result, Operacion_Deducciones.DeducirCajaCompensacion(value, deduction), 0);
    }

    @Test
    public void CajaCompensacion() {
        final RespuestaSalario response = RespuestaSalario.builder()
                        .salarioBase(salarioBase)
                        .aporteCajaDeCompensacion(new Double(40000))
                        .build();

        Assert.assertEquals(response.getAporteCajaDeCompensacion(), Operacion_Deducciones.calcularSalario(salarioBase).getAporteCajaDeCompensacion(), 0);
    }

    @Test
    public void SaludEmpleado(){
        double saludEmpleado = 0.04;
        final RespuestaSalario  resultEmpleado = RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .aporteSaludEmpleado(new Double(40000))
                .build();
      //  Assert.assertEquals(resultEmpleado.getAporteSaludEmpleado(), Operacion_Deducciones.SaludEmpleadoFuncional.apply(saludEmpleado,salarioBase));
    }

    @Test
    public void SaludEmpledoTest(){
        double PagoSaludEmpleado = 0.04;
        final RespuestaSalario  resultEmpleado = RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .aporteSaludEmpleado(new Double(40000))
                .build();
        Assert.assertEquals(resultEmpleado.getAporteSaludEmpleado(), Operacion_Deducciones.saludEmpleado(salarioBase,PagoSaludEmpleado),0);
    }
    @Test
    public void SaludEmpledorTest(){

        double PagoSaludEmpleador = 0.12;
        final RespuestaSalario  resultEmpleado = RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .aporteSaludEmpleador(new Double(120000))
                .build();
        Assert.assertEquals(resultEmpleado.getAporteSaludEmpleador(), Operacion_Deducciones.saludEmpleador(salarioBase, PagoSaludEmpleador),0);
    }
    @Test
    public void PensionEmpleadoTest() {
        double PagoPensionEmpleado = 0.04;
        final RespuestaSalario  resultEmpleado = RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .aportePensionEmpleado(new Double(40000))
                .build();
        Assert.assertEquals(resultEmpleado.getAportePensionEmpleado(), Operacion_Deducciones.pensionEmpleado(salarioBase, PagoPensionEmpleado),0);
    }
    @Test
    public void PensionEmpleadorTest() {
        double PagoPensionEmpleado = 0.085;
        final RespuestaSalario  resultEmpleador = RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .aportePensionEmpleador(new Double(85000))
                .build();
        Assert.assertEquals(resultEmpleador.getAportePensionEmpleador(), Operacion_Deducciones.pensionEmpleador(salarioBase, PagoPensionEmpleado),0);
    }

}