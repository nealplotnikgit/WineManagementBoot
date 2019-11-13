package com.plotnik.winecellar.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WineManagementApplication {
// driver class
	@Bean
	@Scope("prototype")
	Logger logger(InjectionPoint injectionPoint){
	    return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getContainingClass());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WineManagementApplication.class, args);
		//add comment
	}
	
	public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/search").allowedOrigins("*");
                registry.addMapping("/wines").allowedOrigins("*");
            }
        };
    }

}
