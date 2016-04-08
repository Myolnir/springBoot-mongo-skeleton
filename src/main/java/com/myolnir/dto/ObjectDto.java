package com.myolnir.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties (ignoreUnknown = true)
public class ObjectDto {

    private String id;

    private String description;

    @JsonCreator
    private static ObjectDto deserialize (
          @JsonProperty ("id") String id,
          @JsonProperty ("description") String description) {
        return new ObjectDto(id, description);
    }

    public ObjectDto (
          String id,
          String description) {
        this.id = id;
        this.description = description;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }
}
