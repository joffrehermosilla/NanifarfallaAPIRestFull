package joffre.NanifarfallaRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@ComponentScan("joffre.NanifarfallaRest")
@SpringBootApplication
@EnableJpaAuditing
public class NanifarfallaRestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NanifarfallaRestApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NanifarfallaRestApplication.class);
    }	

}
