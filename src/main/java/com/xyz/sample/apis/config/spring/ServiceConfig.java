package com.xyz.sample.apis.config.spring;


import com.xyz.sample.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

/**
 * Created by sumit.nagariya on 12/08/18.
 */
@Configuration
@Import({RepositoryConfig.class, MapperConfig.class})
public class ServiceConfig {

    @Inject
    private RepositoryConfig repositoryConfig;

    @Inject
    private MapperConfig mapperConfig;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    public TestService testService(){
        return new TestService(repositoryConfig.getSampleRepository());
    }
}
