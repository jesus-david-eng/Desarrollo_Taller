package co.com.sofka.calculadora.controller;

import co.com.sofka.calculadora.Operaciones.Operaciones_Calculadora;
import co.com.sofka.calculadora.entity.Credito_Datos;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


import java.util.Arrays;
import java.util.List;

import static co.com.sofka.calculadora.Operaciones.Operaciones_Calculadora.*;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class CaluladoraServices {

    @GetMapping(value = "/suma")
    public Mono<Integer> sumaDosNumeros (Integer a, Integer b) {
        return Mono.just(Arrays.asList(a,b)).flatMap(sumar);
    }

    @GetMapping(value = "/restar")
    public Mono<Integer> restaNumeros(Integer a, Integer b){
        return Mono.just(Operaciones_Calculadora.restar.apply(a,b));
    }

    @GetMapping(value = "/tabla_multiplicar")
    public Mono<String> tabla (Integer x) {
        return Mono.just(x).flatMap(MultiplicarForEach);
    }
    
    @GetMapping(value = "/amortizacion")
    public Mono<List<Credito_Datos>> TableAmortizacion (Integer numCuotas, Integer credito) {
        return Mono.just(Arrays.asList(numCuotas, credito)).flatMap(amortizacion);
    }




}
