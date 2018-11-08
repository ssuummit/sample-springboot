package com.xyz.sample.service;

import com.xyz.sample.dal.model.Test;
import com.xyz.sample.dal.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sumit.nagariya on 08/11/18.
 */
@Service
public class TestService {

    @Autowired
    private SampleRepository sampleRepository;

    private final SampleRepository repository;


    public TestService(SampleRepository repository) {
        this.repository = repository;
    }


    public String testOutput(){
         return "This is test data";
    }

    public int writeToDB(){
        Test sample = new Test();
        sample.setValue("abc");
        Test result = sampleRepository.save(sample);
        return result.getId();
    }
}