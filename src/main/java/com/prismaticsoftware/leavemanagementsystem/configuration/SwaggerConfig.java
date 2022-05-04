package com.prismaticsoftware.leavemanagementsystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Purpose : Implement swagger to handle the run application over server and also in other API
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Purpose : This method is used to specify the swagger to which API(Application Programming Interface)
     * to show on Swagger UI(User Interface) console
     *
     * @return the docket link which has the information about API(Application Programming Interface)
     */
    @Bean
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Leave Management System")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.prismaticsoftware.leavemanagementsystem"))
                .build();
    }
    /**
     * Purpose : This method is used to add extra data's which will give user a proper idea about
     * the API(Application Programming Interface) information in the Swagger UI(User Interface) console
     *
     * @return the swagger API information
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Leave Management System")
                .description("Sample Documentation Generated Using SWAGGER2 for LEave Management System API")
                .termsOfServiceUrl("https://github.com/Sheralram")
                .license("License")
                .licenseUrl("https://github.com/Sheralram")
                .version("1.0")
                .build();
    }
}
