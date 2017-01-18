package evolution;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import evolution.service.AnyService;

// It allows you to define a bean in two ways. One through @Bean and the other one through @ComponentScan.
@SpringBootApplication// Don't make a mistake to write it as @SpringBootConfiguration
@ComponentScan({"evolution"})// Once this annotation is defined. Don't forget to put @Service above AnotherService. You don't need to define a bean for AnotherService in Application. You can omit this tag if you want because the Application is put under the root of evolution package, therefore the default base package is evolution.
public class Application {
	@Bean// Define the bean right here and you can autowire it to the controller. There is no need to put @Service above AnyService.
	public AnyService anyService() {
		return new AnyService();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);// Don't make a mistake to write it as SpringBootApplication.
	}
}
