package com.example.backend.service;

import com.example.backend.utility.NewtonResponse;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

public class IntegralService implements Function<IntegralService.Request, IntegralService.Response> {

    @Override
    public IntegralService.Response apply(IntegralService.Request request) {
        String url = "https://newton.now.sh/api/v2/integrate/"+request.expression;
        RestTemplate restTemplate = new RestTemplate();
        NewtonResponse newtonResponse = restTemplate.getForObject(url, NewtonResponse.class);
        System.out.println("Newton called");
        return new IntegralService.Response(newtonResponse.getResult());
    }

    @Override
    public <V> Function<V, IntegralService.Response> compose(Function<? super V, ? extends IntegralService.Request> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<IntegralService.Request, V> andThen(Function<? super IntegralService.Response, ? extends V> after) {
        return Function.super.andThen(after);
    }

    public record Request(String expression){}
    public record Response(String answer){}
}

