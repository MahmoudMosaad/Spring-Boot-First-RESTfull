//package com.in28minutes.springboot.configuration;
//
//import java.util.Locale;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//
//@Component
//@Configuration
//public class Configur {
//
//	@Bean
//	public LocaleResolver localeResolver() {
//		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//		sessionLocaleResolver.setDefaultLocale(Locale.US);
//		return sessionLocaleResolver;
//	}
//
//	@Bean
//	public ResourceBundleMessageSource bundleMessageSource() {
//		System.out.println("henaaaaaaaaaaaaaaaaaaaa");
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}
//}
