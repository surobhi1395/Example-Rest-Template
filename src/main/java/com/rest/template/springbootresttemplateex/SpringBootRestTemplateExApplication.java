package com.rest.template.springbootresttemplateex;

import com.rest.template.springbootresttemplateex.service.validate.UserValidation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestTemplateExApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootRestTemplateExApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public UserValidation userValidation(){
            return new UserValidation();
    }

}
