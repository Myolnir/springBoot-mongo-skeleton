package com.myolnir.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * POJO that will be stored in DB
 */
@Document
public class ObjectToSave {

    @Id
    private String id;

    private String foo;

    public String getFoo () {
        return foo;
    }

    public void setFoo (String foo) {
        this.foo = foo;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }
}
