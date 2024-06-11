package com.example.backend.configs;

import com.example.backend.service.DerivativeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class Config {

    @Bean
    @Description("Differentiate the expression")// function description
    public Function<DerivativeService.Request, DerivativeService.Response> mathFunction() {
        return new DerivativeService();
    }
}
