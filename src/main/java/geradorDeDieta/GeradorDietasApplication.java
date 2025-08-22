package geradorDeDieta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta anotação mágica transforma a classe na principal da sua aplicação Spring
@SpringBootApplication
public class GeradorDietasApplication {

    public static void main(String[] args) {
        // Esta linha inicia todo o servidor e sua aplicação
        SpringApplication.run(GeradorDietasApplication.class, args);
    }
}