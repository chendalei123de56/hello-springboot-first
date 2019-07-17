package com.hecdu.springboot.first;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloSpringbootFirstApplication.class,
                webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloSpringbootFirstApplicationTests {
    @LocalServerPort//把随机端口号注入进来
    private  int port;
    @Autowired
    private TestRestTemplate restTemplate;
    //存储服务端资源的主机和端口信息
    private URL base;//它由协议。主机，端口
    @Before
    public void setUp() throws MalformedURLException {
        this.base=new URL("http://localhost:"+port+"/");
    }
    @Test
    public void contextLoads() {
        String resource="index";
        ResponseEntity<String> responce=
                restTemplate.getForEntity(base.toString()+resource,
                                            String.class);
        System.out.println(responce.getStatusCode().value());
        System.out.println(responce.getBody());
        //
        //Assert.assertEquals("响应失败",201,responce.getStatusCodeValue());
        Assert.assertThat("欢迎使用Springboot,",
                Matchers.equalTo("欢迎使用Springboot,它会使你快乐!!!"));
    }

}
