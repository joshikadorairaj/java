package com.kgisl.SpringStudentCRUD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.kgisl.SpringStudentCRUD.model.Helloworld;
@Configuration
@EnableWebMvc
public class Beanscope {
    @Bean
    @Scope("singleton")
    public Helloworld helloworld() {
        return new Helloworld();
    }
}
