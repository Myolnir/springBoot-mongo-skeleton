package com.myolnir.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties (ignoreUnknown = true)
public class ObjectDto {

    private String id;

    private String foo;

    @JsonCreator
    private static ObjectDto deserialize (
          @JsonProperty ("id") String id,
          @JsonProperty ("foo") String foo) {
        return new ObjectDto(id, foo);
    }

    public ObjectDto (
          String id,
          String foo) {
        this.id = id;
        this.foo = foo;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getFoo () {
        return foo;
    }

    public void setFoo (String foo) {
        this.foo = foo;
    }
}
