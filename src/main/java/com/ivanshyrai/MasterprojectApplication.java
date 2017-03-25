package com.ivanshyrai;

import com.ivanshyrai.config.PictureUploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({PictureUploadProperties.class})
public class MasterprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterprojectApplication.class, args);
	}
}
