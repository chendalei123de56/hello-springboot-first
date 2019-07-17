package com.hecdu.springboot.first;

import com.hecdu.springboot.first.config.AppConfig;
import com.hecdu.springboot.first.data.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Import(AppConfig.class)
public class HelloSpringbootFirstApplication {
    @Autowired
    private Data data;
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringbootFirstApplication.class, args);
    }
}
