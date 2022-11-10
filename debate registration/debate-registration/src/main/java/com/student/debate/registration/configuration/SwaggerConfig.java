package com.student.debate.registration.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket studentApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.groupName("Student-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.student.debate.registration.controller")).build();
	}
	
	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		
		String title = "Atudent API";
		String titleDescription = "Student API reference for developer";
		String termsOfService = "to e used with concent of Anuj";
		
		return new ApiInfoBuilder().title(title).description(titleDescription)
				.termsOfServiceUrl(termsOfService)
				.license("Student License")
				.licenseUrl("http://fakestudent.com")
				.version("1.0")
				.build();
	}
	
}
	
	
	