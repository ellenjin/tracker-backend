package com.adadev.tracker_backend.model;
import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    
    private String name;
    private String picture; 
    private String description;
    private Group() {
    }

    public Group(String name, String description, String picture) {
        this.name = name;
        this.picture = picture;
        this.description = description;
    }

    public Integer getId(){
        return this.id;
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
