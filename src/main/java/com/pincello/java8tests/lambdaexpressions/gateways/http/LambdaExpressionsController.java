// https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm

package com.pincello.java8tests.lambdaexpressions.gateways.http;

import com.pincello.java8tests.lambdaexpressions.usecases.MathOperation;
import com.pincello.java8tests.lambdaexpressions.usecases.Operator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.BiFunction;
import java.util.function.Function;

@RestController
@RequestMapping(LambdaExpressionsController.LAMBDA_EXPRESSIONS)
@RequiredArgsConstructor
public class LambdaExpressionsController {

    public static final String LAMBDA_EXPRESSIONS = "/lambda-expressions";

    private final Operator operator;

    //with type declaration
    private MathOperation addition = (int a, int b) -> a + b;

    //with out type declaration
    private MathOperation subtraction = (a, b) -> a - b;

    //with return statement along with curly braces
    private MathOperation multiplication = (int a, int b) -> { return a * b; };

    //without return statement and without curly braces
    private MathOperation division = (int a, int b) -> a / b;

    private Function<Integer, Integer> fnPow = (Integer a) -> a * a;

    private BiFunction<Integer, Integer, Integer> fnAddiction = (Integer a, Integer b) -> a + b;

    @GetMapping
    public ResponseEntity<String> lambdaExpressions() {
        System.out.println("10 + 5 = " + operator.execute(10, 5, addition));
        System.out.println("10 - 5 = " + operator.execute(10, 5, subtraction));
        System.out.println("10 * 5 = " + operator.execute(10, 5, multiplication));
        System.out.println("10 / 5 = " + operator.execute(10, 5, division));
        System.out.println("10 * 10 = " + fnPow.apply(10));
        System.out.println("10 + 5 = " + fnAddiction.apply(10, 5));

        return ResponseEntity.ok("teste");
    }
}
