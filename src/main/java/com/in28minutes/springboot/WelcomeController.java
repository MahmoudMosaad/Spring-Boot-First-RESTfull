package com.in28minutes.springboot;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.configuration.BasicConfiguration;

@RestController
public class WelcomeController {

	//Auto wiring
	@Autowired
	private WelcomeService service;
	@Autowired
	private BasicConfiguration config;
	@Autowired
	private ResourceBundleMessageSource messageSource;

	@RequestMapping("/welcome")
	public String welcome() {
		return service.retrieveWelcomeMessage();
	}
	
	@RequestMapping("/hello-worled-internationalized")
	public String helloWorled(@RequestHeader(name = "Accept-Language", required = false) Locale locale ) {
		return messageSource.getMessage("good.morning.message",null, locale);
	}
	
	@RequestMapping("/basic-config")
	public Map<Object,Object> config() {
		Map<Object,Object> map = new HashMap<>();
		map.put("message", config.getMessage());
		map.put("number", config.getNumber());
		map.put("value", config.isValue());
		return map;
	}
}