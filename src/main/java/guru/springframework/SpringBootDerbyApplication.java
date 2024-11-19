package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "guru.springframework")
public class SpringBootDerbyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDerbyApplication.class, args);
	}
}
