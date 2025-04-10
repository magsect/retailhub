package config.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.retailhub.repository.jpa")
@EnableTransactionManagement
@EnableJpaAuditing
public class JpaConfig {
    // Additional JPA configuration if needed
}