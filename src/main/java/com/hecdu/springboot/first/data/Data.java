package com.hecdu.springboot.first.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@ConfigurationProperties(prefix = "message")
//@EnableConfigurationProperties(Data.class)
@Component

public class Data
{
   // @Value("message.title")
    private String title;
//    @Value("message.body")
    private String  body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
