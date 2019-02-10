package demo.cosmos.core.policy.api;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.cache.annotation.EnableCaching;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration

@PropertySource("classpath:log.messages")
@EnableJpaRepositories(basePackages = { "demo.cosmos.core.policy.dao" })
@EntityScan(basePackages = { "demo.cosmos.core.policy.dao" })
@EnableCaching

public class ApplicationConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}