package config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.retailhub.repository.mongodb")
@EnableMongoAuditing
public class MongoConfig {
    // Additional MongoDB configuration if needed
}