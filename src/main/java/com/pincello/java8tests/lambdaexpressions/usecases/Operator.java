package com.pincello.java8tests.lambdaexpressions.usecases;

import org.springframework.stereotype.Service;

@Service
public class Operator {

    public int execute(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
