package xyz.cym2018;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@RestController
@ServletComponentScan(basePackages = "xyz.cym2018.filter")
public class Application {
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    DriverManagerDataSource dataSource() {
        return new DriverManagerDataSource();
    }

    @Bean
    ObjectMapper CreateObjectMapper() {
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return objectMapper;
    }
}
