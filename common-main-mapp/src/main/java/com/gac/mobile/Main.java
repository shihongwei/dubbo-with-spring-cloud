package com.gac.mobile;

import sample.ds.cn.util.ContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;


@ComponentScan(basePackages = {"com.gac.mobile","sample.ds.cn"})
@ImportResource(locations = {"classpath:conf/*.xml"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = {"sample.ds.cn", "com.gac.mobile"})
@EnableHystrixDashboard
@SpringCloudApplication
public class Main extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
//        System.setProperty("spring.profiles.active", "test");
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        ContextUtil.setApplicationContext(applicationContext);
    }

    @Bean
    @LoadBalanced
        // see org/springframework/cloud/client/loadbalancer/LoadBalancerAutoConfiguration.java
        // line 80
    RestTemplate restTemplate() {
        return new RestTemplate();
    }



}