package com.dheanBank.dheanBank;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Dhean Bank App",
                description = "Backend rest api for Dhean Bank",
                version = "v1.0",
                contact = @Contact(
                        name = "Daniel Ibisagba",
                        email = "danielibisagba@gmail.com",
                        url = "https://github.com/dhean4/dhean-bank"
                ),
                license = @License(
                        name = "Dhean",
                        url = "https://github.com/dhean4/dhean-bank"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Dhean Documentation",
                url = "https://github.com/dhean4/dhean-bank"
        )

)
public class DheanBankApplication {


	public static void main(String[] args) {
		SpringApplication.run(DheanBankApplication.class, args);
	}

}
