package zw.org.mohcc.cdss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "zw.org.mohcc.cdss.model.entity")
@EnableJpaRepositories(basePackages = "zw.org.mohcc.cdss.repository")
public class CdssApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdssApplication.class, args);
	}

}
