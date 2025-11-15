package com.training.aws.netflux.movie_service;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestContainersConfiguration {

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		// This is common docker pull from docker hub
		//return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));

		// This is pull from ECR
		DockerImageName dockerImage =
				DockerImageName.parse("public.ecr.aws/docker/library/postgres:latest")
						.asCompatibleSubstituteFor("postgres");
		return new PostgreSQLContainer<>(dockerImage)
				.withDatabaseName("movie")
				.withInitScript("init-db.sql");
	}

}
