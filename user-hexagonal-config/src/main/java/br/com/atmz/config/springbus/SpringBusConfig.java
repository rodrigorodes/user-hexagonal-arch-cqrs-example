package br.com.atmz.config.springbus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.atmz.commons.cqrs.Bus;
import br.com.atmz.commons.cqrs.Registry;
import br.com.atmz.commons.cqrs.ServiceBus;

@Configuration
public class SpringBusConfig {
	
	@Bean
	public Registry registry(ApplicationContext applicationContext) {
		return new Registry(applicationContext);
	}

	@Bean
	public Bus commandBus(Registry registry) {
		return new ServiceBus(registry);
	}
}
