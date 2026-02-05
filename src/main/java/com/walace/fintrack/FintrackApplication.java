package com.walace.fintrack;

import com.walace.fintrack.domain.Category;
import com.walace.fintrack.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FintrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FintrackApplication.class, args);
	}

	// Roda uma vez quando a aplicação sobe
	@Bean
	CommandLineRunner seed(CategoryRepository repo) {
		return args -> {
			// Evita duplicar quando reiniciar
			if (repo.count() == 0) {
				repo.save(new Category("Alimentação"));
				repo.save(new Category("Transporte"));
				repo.save(new Category("Salário"));
			}
		};
	}
}
