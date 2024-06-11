package com.example.backend.service;

import com.example.backend.utility.NewtonResponse;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

public class ZeroesService implements Function<ZeroesService.Request, ZeroesService.Response> {
    @Override
    public ZeroesService.Response apply(ZeroesService.Request request) {
        String url = "https://newton.now.sh/api/v2/zeroes/"+request.expression;
        RestTemplate restTemplate = new RestTemplate();
        NewtonResponse newtonResponse = restTemplate.getForObject(url, NewtonResponse.class);
        System.out.println("Newton called");
        return new ZeroesService.Response(newtonResponse.getResult());
    }

    @Override
    public <V> Function<V, ZeroesService.Response> compose(Function<? super V, ? extends ZeroesService.Request> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<ZeroesService.Request, V> andThen(Function<? super ZeroesService.Response, ? extends V> after) {
        return Function.super.andThen(after);
    }

    public record Request(String expression){}
    public record Response(String answer){}
}

