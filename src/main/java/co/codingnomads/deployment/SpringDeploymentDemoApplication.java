package co.codingnomads.deployment;

import co.codingnomads.deployment.models.Hello;
import co.codingnomads.deployment.repositories.HelloRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
public class SpringDeploymentDemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringDeploymentDemoApplication.class, args);
	}

	@Value("${db.password}")
	private String password;

	@Bean
	public CommandLineRunner loadInitialData(HelloRepository helloRepository) {
		return (args) -> {
			System.out.println(password);
			if (helloRepository.findAll().size() == 0) {
				helloRepository.save(new Hello("CodingNomads"));
			}
		};
	}
}