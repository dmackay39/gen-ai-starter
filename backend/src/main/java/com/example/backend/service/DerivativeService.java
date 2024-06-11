package com.example.backend.service;

import com.example.backend.utility.NewtonResponse;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

public class DerivativeService implements Function<DerivativeService.Request, DerivativeService.Response> {

    @Override
    public Response apply(Request request) {
        String url = "https://newton.now.sh/api/v2/derive/"+request.expression;
        RestTemplate restTemplate = new RestTemplate();
        NewtonResponse newtonResponse = restTemplate.getForObject(url, NewtonResponse.class);
        System.out.println("Newton called");
        return new Response(newtonResponse.getResult());
    }

    @Override
    public <V> Function<V, Response> compose(Function<? super V, ? extends Request> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Request, V> andThen(Function<? super Response, ? extends V> after) {
        return Function.super.andThen(after);
    }

    public record Request(String expression){}
    public record Response(String answer){}

}
