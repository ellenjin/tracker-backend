package com.adadev.tracker_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer groupId;
    
    private String groupName;
    private String groupPicture; 
    private String groupDescription; 

    // Hibernate needs entities to have a no-arg constructor, but it doesn't have to be public.
    private Group() {
    }

    public Group(String name, String description, String picture) {
        this.groupName = name;
        this.groupPicture = picture;
        this.groupDescription = description;
    }

    public String getName() {
        return this.groupName;
    }

    public String getPicture() {
        return this.groupPicture;
    }

    public String getDescription() {
        return this.groupDescription;
    }

    // Setters to update fields if the user choose to edit group details
    public void setName(String name) {
        this.groupName = name;
    }

    public void setPicture(String picture) {
        this.groupPicture = picture;
    }

    public void setDescription(String description) {
        this.groupDescription = description;
    }


}
