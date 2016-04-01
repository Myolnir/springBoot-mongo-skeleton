package com.myolnir.model;

import javax.persistence.*;

@Entity
@Table
public class RelationalObject {

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column
    private String comments;

    public RelationalObject () {
    }

    public RelationalObject (String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getComments () {
        return comments;
    }

    public void setComments (String comments) {
        this.comments = comments;
    }
}
