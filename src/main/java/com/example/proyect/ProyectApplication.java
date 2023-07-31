package com.example.proyect;
import com.example.proyect.repository.ICharacterRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@OpenAPIDefinition(info= @Info(title="Libreria proyecto"))
public class ProyectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProyectApplication.class, args);
       ICharacterRepository CharacterRepository = context.getBean(ICharacterRepository.class);

    }

}
