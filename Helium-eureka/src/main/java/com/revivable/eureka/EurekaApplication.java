package com.revivable.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 只需要使用@EnableEurekaServer注解就可以让应用变为Eureka Server
 * pom中要添加对应的spring-cloud-starter-netflix-eureka-server依赖
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
