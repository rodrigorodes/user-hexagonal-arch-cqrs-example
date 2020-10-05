package br.com.atmz.config.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import br.com.atmz.adapter.user.entity.UserJpa;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.atmz"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiEndPointsInfo())
                .consumes(getAllConsumeContentTypes())
                .produces(getAllProduceContentTypes())
                .ignoredParameterTypes(UserJpa.class)
                .globalOperationParameters(
                        Arrays.asList(
                                new ParameterBuilder()
                                    .name("Authorization")
                                    .description("Header para Token JWT")
                                    .modelRef(new ModelRef("string"))
                                    .parameterType("header")
                                    .required(false)
                                    .build()));
    }
    
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Hexagonal CQRS REST API")
            .description("Forum Management REST API")
            .contact(new Contact("Rodrigo mendes", "Contact", "ro.mendes1989@gmail.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }
    
    private Set<String> getAllConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        // Add other media types if required in future
        consumes.add(MediaType.APPLICATION_JSON_VALUE);
        consumes.add("application/vnd.market-scan.v1+json");
        return consumes;
    }

    private Set<String> getAllProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        // Add other media types if required in future
        produces.add(MediaType.APPLICATION_JSON_VALUE);
        return produces;
    }

}