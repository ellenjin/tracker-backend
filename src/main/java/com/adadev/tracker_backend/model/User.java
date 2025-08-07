package com.adadev.tracker_backend.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

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
    @NotBlank(message = "Username required")
    @Pattern(
            regexp = "^(?=.*[a-zA-Z]).*$",
            message = "Must contain at least one letter"
    )
    private String username;
    @Pattern(
            regexp = "^\\d{10,11}$",
            message = "Phone number must be only 10-11 digits"
    )
    private String phoneNumber;
    @ElementCollection
    @CollectionTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "friend_id")
    private Set<Integer> friends = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "user_interests",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "interest")
    private Set<String> interests = new HashSet<>(); // store friends by ID

    @ManyToMany
    @JoinTable(
            name = "user_group", // junction table between user and group
            joinColumns = @JoinColumn(name="user_id"), // FK in junction table
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> groups = new HashSet<>(); // Tells Hibernate that we want to link Group to User (we're in User file)
    // Currently, mapping is set to be just unidirectional -- bidirectional creates more challenges with updating on both sides

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL, // User operations will cascade to logs
            orphanRemoval = true) // delete logs that are removed from the set (below)
    @JsonManagedReference
    private Set<Log> logs = new HashSet<>();
    // Hibernate needs entities to have a no-arg constructor, but it doesn't have to be public.
    private User() {}

    public User(String username, String phoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
//        this.interests = new HashSet<>();
    }

    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public Set<String> getInterests() { return interests; }

    public void updateInterests(Set<String> newInterests) {
        this.interests = newInterests;
    }

    public Set<Integer> getFriends() {
        if (friends == null) {
            friends = new HashSet<>();
        }
        return friends;
    }

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }
}