package com.example.backend.configs;

import com.example.backend.service.DerivativeService;
import com.example.backend.service.IntegralService;
import com.example.backend.service.ZeroesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class Config {

    @Bean
    @Description("Differentiate the expression")
    public Function<DerivativeService.Request, DerivativeService.Response> diffFunction() {
        return new DerivativeService();
    }

    @Bean
    @Description("Integrate the expression")
    public Function<IntegralService.Request, IntegralService.Response> intFunction() {
        return new IntegralService();
    }

    @Bean
    @Description("Find the zeroes of the expression")
    public Function<ZeroesService.Request, ZeroesService.Response> zeroesFunction() {
        return new ZeroesService();
    }
}
