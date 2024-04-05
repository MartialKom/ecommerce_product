package com.ecommerce.martialKom_microcommerce.config;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
        info =@Info(
                title = "Ecommerce Product API",
                version = "1.0",
                contact = @Contact(
                        name = "Martial KOM KANMEGNE", email = "martialkom123@gmail.com", url = "https://github.com/MartialKom"
                ),
                license = @License(
                        name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                description = "Product micro service for ecommerce App"
        )
)
public class SwaggerConfig {

}
