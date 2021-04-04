package com.dev.javadev.vavr;

import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.control.Either;
import io.vavr.control.Try;

import java.util.function.BiFunction;

public class MyVavr {
    // c'est quoi l'intérêt ?
    Function2<Integer, Integer, Integer> sum = (a, b) -> a / b;
    BiFunction<Integer, Integer, Integer> mySum = (a, b) -> a + b;

    // partial application
    Function3<Integer, Integer, Integer, Integer> sum2 = (a, b, c) -> a + b + c;
    Function2<Integer, Integer, Integer> alwaysSumWith2 = sum2.apply(2);

    Function0<Either<String, Integer>> afaezfez = () -> {
        System.out.println("toto");
        Try.success("ok")
                .andThen(() -> {
                })
                .andThen(() -> {
                })
                .onFailure(System.out::println);
        Try.of(() -> sum.apply(9).apply(6))
                .onFailure(System.out::println);

        return Either.right(9);
    };

    BiFunction myVoid = (a, b) -> {
        System.out.println("toto");
        return null;
    };

    public void dadeazde() {
        System.out.println("toto");
    }


}
