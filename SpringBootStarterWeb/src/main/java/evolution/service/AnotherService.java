package evolution.service;

import org.springframework.stereotype.Service;

@Service// You can put @Service here, but don't forget to put @ComponentScan along with base package name in Application.
public class AnotherService {
	public void anyMethod() {
		System.out.println("Hello World");
	}
}
