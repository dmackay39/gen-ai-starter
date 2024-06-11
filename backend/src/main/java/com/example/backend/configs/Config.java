package com.example.backend.configs;

import com.example.backend.service.DerivativeService;
import com.example.backend.service.IntegralService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class Config {

    @Bean
    @Description("Differentiate the expression")// function description
    public Function<DerivativeService.Request, DerivativeService.Response> diffFunction() {
        return new DerivativeService();
    }

    @Bean
    @Description("Integrate the expression")// function description
    public Function<IntegralService.Request, IntegralService.Response> intFunction() {
        return new IntegralService();
    }
}
