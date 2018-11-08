package com.xyz.sample.apis.config.spring;

import com.xyz.sample.apis.controller.TestController;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.inject.Inject;

/**
 * Created by sumit.nagariya on 08/11/18.
 */
@Configuration
@ComponentScan({ "com.xyz.sample.apis", "com.xyz.sample.dal" })
@EnableConfigurationProperties
@Import({ ServiceConfig.class, MapperConfig.class})
public class ApplicationConfig {
    @Inject
    private ServiceConfig serviceConfig;

    @Inject
    private MapperConfig mapperConfig;

    @Inject
    private SwaggerConfig swaggerConfig;

    @Bean
    public TestController testController(){
        return new TestController(serviceConfig.testService());
    }
}