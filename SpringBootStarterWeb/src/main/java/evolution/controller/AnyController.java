package evolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
