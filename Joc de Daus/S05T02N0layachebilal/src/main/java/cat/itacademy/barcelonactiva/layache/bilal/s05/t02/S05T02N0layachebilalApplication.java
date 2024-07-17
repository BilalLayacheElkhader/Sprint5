package cat.itacademy.barcelonactiva.layache.bilal.s05.t02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player")
@EnableMongoRepositories(basePackages = "cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.game")
public class S05T02N0layachebilalApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T02N0layachebilalApplication.class, args);
	}

}
