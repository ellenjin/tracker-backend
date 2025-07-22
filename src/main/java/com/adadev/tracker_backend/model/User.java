package com.adadev.tracker_backend.model;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // autogenerate keys.
    private Integer id;
    // Since we use the @GeneratedValue annotation, Postgres is responsible for creating
    // ids for new User objects -- don't need id parameter in constructor.
    private String username;

    // Apparently, Hibernate needs entities to have a no-arg constructor
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

}
