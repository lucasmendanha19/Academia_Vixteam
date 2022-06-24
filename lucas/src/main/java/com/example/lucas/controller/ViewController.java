package com.example.lucas.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/cadastro").setViewName(("forward: /telaCadastro.html"));
        registry.addViewController("/index").setViewName("forward: /index.html");
        registry.addViewController("/consulta").setViewName("forward: /telaConsulta.html");
    }


}
