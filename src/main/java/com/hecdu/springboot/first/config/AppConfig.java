package com.hecdu.springboot.first.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:props/data.properties")
public class AppConfig {
    //nothing
}
