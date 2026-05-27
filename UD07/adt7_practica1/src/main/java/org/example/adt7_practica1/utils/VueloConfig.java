package org.example.adt7_practica1.utils;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VueloConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("API de Vuelos")
                        .description("Ejemplo de API para gestionar Vuelos")
                        .contact(new Contact()
                                .name("Marcos Durá")
                                .email("mardurbla@alu.edu.gva.es")
                                .url("https://ieslluissimarro.org/"))
                        .version("1.0"));
    }

}
