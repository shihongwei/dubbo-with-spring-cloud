package com.gac.adv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"com.gac", "sample.ds"})
@ImportResource(locations = {"classpath:conf/*.xml"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = {"com.gac", "sample.ds"})
@EnableHystrixDashboard
@SpringCloudApplication
public class ADVProvider {

    public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "development");
        ApplicationContext applicationContext = SpringApplication.run(ADVProvider.class, args);
    }

}