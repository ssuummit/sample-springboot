package com.xyz.sample.dal.repository;

import com.xyz.sample.dal.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sumit.nagariya on 08/11/18.
 */
@Repository
public interface SampleRepository extends JpaRepository<Test, Long> {

}