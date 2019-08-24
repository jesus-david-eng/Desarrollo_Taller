package co.com.sofka.calculadora.Operaciones;

import co.com.sofka.calculadora.entity.RespuestaSalario;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class Operacion_Deducciones {

    final static double CAJA_COMPENSACION = 0.04;

    public static double DeducirCajaCompensacion(double value, double deduction) {
        return value * deduction;
    }

    public static Function<RespuestaSalario, RespuestaSalario> deduceAll() {
        return r -> r.toBuilder()
                .aporteCajaDeCompensacion( DeducirCajaCompensacion(r.getSalarioBase(), CAJA_COMPENSACION) )
                .build();
    }

    public static RespuestaSalario calcularSalario(Double salarioBase) {
        return Stream.of(RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .build()).map(Operacion_Deducciones.deduceAll()).reduce(RespuestaSalario.builder().build(), (r1, r2) -> r2);
    }

    public static BiFunction<Double,Double,Double> SaludEmpleadoFuncional = (a,b) ->  a*b;

    public static double saludEmpleado(double salarioBase, double aporteSaludEmpleado) {
        return salarioBase * aporteSaludEmpleado;
    }

    public static double saludEmpleador(double salarioBase, double aporteSaludEmpleador) {
        return salarioBase * aporteSaludEmpleador;
    }

    public static double pensionEmpleado(double salarioBase, double aportePensionEmpleado) {
        return salarioBase * aportePensionEmpleado;
    }

    public static double pensionEmpleador(double salarioBase, double aportePensionEmpleador) {
        return salarioBase * aportePensionEmpleador;
    }


}
