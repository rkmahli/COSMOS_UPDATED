package demo.cosmos.core.policy.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.cognizant.cosmos", "demo.cosmos.core.policy" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}