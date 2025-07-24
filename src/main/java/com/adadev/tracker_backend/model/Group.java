package com.adadev.tracker_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // autogenerate keys.
    private Integer id;
    private String name; // group name
    private String description; // description of what the group is / tracking topic / info

    private Group() {
    }

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
