package br.com.listaTarefas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Define os endpoints que permitem CORS (aqui, todos)
                        .allowedOrigins("http://localhost:4200") // Adicione as origens permitidas
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Métodos HTTP permitidos
                        .allowedHeaders("*") // Cabeçalhos permitidos
                        .allowCredentials(true); // Permitir cookies e credenciais
            }
        };
    }
}

