package co.com.sofka.calculadora.Operaciones;

import co.com.sofka.calculadora.entity.Credito_Datos;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

import static reactor.core.publisher.Flux.just;

public class Operaciones_Calculadora {

    public static final Function<List<Integer>, Mono<Integer>> sumar = lista ->
            Mono.just(lista.stream().reduce(0, (a, b) -> a + b)
            );

    public static BiFunction<Integer,Integer,Integer> restar = (x,y) ->  x - y;


    public static final Function<Integer, Mono<String>> MultiplicarFor = x -> {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int multi = x * i;
            list.add(multi);
        }
        return Mono.just(list.toString());
    };

    public static final Function<Integer, Mono<String>> MultiplicarForEach = x -> {
        List<Integer> list = new ArrayList<>();
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 9, 10};
        for (int i : arreglo) {
            int multi = x * i;
            list.add(multi);
        }
        return Mono.just(list.toString());
    };


    public static final Function<List<Integer>, Mono<List<Credito_Datos>>> amortizacion = lista -> {
        final Integer numCuotas = lista.get(0);
        final Integer  credito = lista.get(1);
        final Double Interes = 0.01;
        final Double amortizacionDelCapital = (double)  credito/  numCuotas;
        List<Credito_Datos> prestamosTable = new ArrayList<>(lista.get(0));
        IntStream.rangeClosed(1,  numCuotas).forEach(

                periodo -> prestamosTable.add(Credito_Datos.builder()
                        .periodo(periodo)
                        .interes( credito * Interes)
                        .amortizacionCapital(amortizacionDelCapital)
                        .cuota( Interes*  credito + amortizacionDelCapital)
                        .capitaPendiente( credito - amortizacionDelCapital * periodo).build()));
        return Mono.just(prestamosTable);
    };


}