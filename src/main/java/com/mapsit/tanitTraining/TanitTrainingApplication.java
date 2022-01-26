package com.mapsit.tanitTraining;

import com.mapsit.tanitTraining.security.SpringSecurityAuditorAware;
import com.mapsit.tanitTraining.security.jwt.MyWayProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableConfigurationProperties({MyWayProperties.class})
@EnableSwagger2 // swagger va scan voter projet et génére une documentaion pour votre API
@ComponentScan("com.mapsit.tanitTraining")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class TanitTrainingApplication {


    public static void main(String[] args) {
        SpringApplication.run(TanitTrainingApplication.class, args);

    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @PostConstruct
    public void init(){
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }



    @Bean
    public AuditorAware<String> auditorAware(){
        return new SpringSecurityAuditorAware();
    }

}