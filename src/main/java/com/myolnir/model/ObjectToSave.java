package com.myolnir.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * POJO that will be stored in DB
 */
@Document
public class ObjectToSave {

    private String foo;

    public String getFoo () {
        return foo;
    }

    public void setFoo (String foo) {
        this.foo = foo;
    }
}
