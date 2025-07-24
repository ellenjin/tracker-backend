package com.adadev.tracker_backend.model;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // autogenerate keys.
    private Integer id;
    // Since we use the @GeneratedValue annotation, Postgres is responsible for creating
    // ids for new User objects -- don't need id parameter in constructor.
    private String username;

    @ManyToMany
    @JoinTable(
            name = "user_group", // junction table between user and group
            joinColumns = @JoinColumn(name="user_id"), // FK in junction table
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> groups = new HashSet<>(); // Tells Hibernate that we want to link Group to User (we're in User file)
    // Currently, mapping is set to be just unidirectional -- bidirectional creates more challenges with updating on both sides

    // Hibernate needs entities to have a no-arg constructor, but it doesn't have to be public.
    private User() {}

    public User(String username) {
        this.username = username;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addToGroup(Group group) {
        groups.add(group);
    }
}
