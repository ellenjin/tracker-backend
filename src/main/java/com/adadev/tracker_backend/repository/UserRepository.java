package com.adadev.tracker_backend.repository;

import com.adadev.tracker_backend.model.Group;
import com.adadev.tracker_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // You can add custom query methods here, like:
    Optional<User> findByUsername(String username); // Optional is good for handling missing users

    // but there are also a lot of query methods that are already written in JpaRepository!
    List<User> findAllByGroupsContains(Group group); // using Spring Data JPA method name conventions
    // Can do this because we have @many-to-many relationship set up between User and Group
}
