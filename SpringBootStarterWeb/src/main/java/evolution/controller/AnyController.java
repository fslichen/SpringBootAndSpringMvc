package evolution.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import evolution.dto.PostDto;
import evolution.service.AnotherService;
import evolution.service.AnyService;

@RestController
public class AnyController {
	@Autowired// In order to autowire, don't forget to define the bean inside Application.
	AnyService anyService;
	
	@Autowired// In order to autowire, don't forget to put @Service above AnotherService and don't forget to put @ComponentScan above Application.
	AnotherService anotherService;
	
	@RequestMapping(value = "/0", method = RequestMethod.GET)
	public void runAnyService() {
		anyService.anyMethod();
	}
	
	@RequestMapping(value = "/1", method = RequestMethod.GET)
	public void runAnotherService() {
		anotherService.anyMethod();
	}
	
	@GetMapping("/2/{parameter}") 
	public void getRequest(@PathVariable("parameter") String parameter) {
		System.out.println(parameter);
	}
	
	@PostMapping("/3")
	public void postRequest(@RequestBody PostDto postDto) {
		System.out.println(postDto);
	}
	
	@RequestMapping(value = "/4", method = RequestMethod.GET) 
	public ResponseEntity<Void> jump() throws URISyntaxException {
		return ResponseEntity.status(HttpStatus.FOUND).location(new URI("http://www.baidu.com")).build();
	}
}
