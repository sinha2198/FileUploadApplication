package com.example.fileupload.app;

import com.example.fileupload.app.config.StorageProperties;
import com.example.fileupload.app.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FileUploadAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadAppApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
