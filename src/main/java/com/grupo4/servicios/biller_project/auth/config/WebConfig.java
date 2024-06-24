package com.grupo4.servicios.biller_project.auth.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://biller-project-services-front.onrender.com") // Permitir todas las solicitudes desde cualquier origen
                .allowedMethods("*") // Permitir todos los métodos HTTP (GET, POST, PUT, DELETE, etc.)
                .allowedHeaders("*"); // Permitir todos los encabezados
    }
}
