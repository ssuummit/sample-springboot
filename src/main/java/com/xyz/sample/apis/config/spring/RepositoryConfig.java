package com.xyz.sample.apis.config.spring;

import com.xyz.sample.dal.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.inject.Inject;

/**
 * Created by sumit.nagariya on 12/08/18.
 */
@Configuration
@Import(MySqlDataSourceConfig.class)
public class RepositoryConfig {

    @Inject
    private MySqlDataSourceConfig mySqlDataSourceConfig;

    @Autowired
    private SampleRepository sampleRepository;

    @Bean
    public SampleRepository getSampleRepository() {
        return sampleRepository;
    }

}
