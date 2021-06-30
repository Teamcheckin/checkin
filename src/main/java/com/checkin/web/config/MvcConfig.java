package com.checkin.web.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path uploadDir = Paths.get("./upload/");
		System.out.println(uploadDir);
		
        String uploadPath = uploadDir.toFile().getAbsolutePath();
         
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/"+ uploadPath + "/");
	}
		
}
