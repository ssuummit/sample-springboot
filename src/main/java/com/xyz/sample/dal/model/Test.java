package com.xyz.sample.dal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sumit.nagariya on 08/11/18.
 */
@Entity
@Table(name = "sample_table")
public class Test {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(name = "value", columnDefinition = "varchar(60)")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }
}