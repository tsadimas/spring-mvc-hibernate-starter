package gr.hua.dit.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()                                       
        	      .apis(RequestHandlerSelectors.basePackage("gr.hua.dit.api"))
        	      .paths(PathSelectors.ant("/api/**"))                     
        	      .build()
        	    	 .apiInfo(apiInfo());
    }

	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("SCHOOL REST API")
            .description("This is the REST API of the samnple project for the scope of Distributed Systems laboratory")
            .version("1.0")
            .termsOfServiceUrl("http://terms-of-services.url")
            .license("LICENSE")
            .licenseUrl("http://url-to-license.com")
            .build();
    }
	
   
}
