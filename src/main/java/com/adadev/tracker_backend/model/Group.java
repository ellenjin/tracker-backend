package com.adadev.tracker_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // autogenerate keys
    private Integer groupId;
    private String name; // group name
    private String picture; // group picture
    private String description; // group description of what the group is / tracking topic / info

    // Hibernate needs entities to have a no-arg constructor, but it doesn't have to be public.
    private Group() {
    }

    public Group(String name, String description, String picture) {
        this.name = name;
        this.picture = picture;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getDescription() {
        return this.description;
    }

    // Setters to update fields if the user choose to edit group details
    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
