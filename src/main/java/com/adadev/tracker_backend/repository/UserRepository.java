package com.adadev.tracker_backend.repository;

import com.adadev.tracker_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // You can add custom query methods here, like:
    Optional<User> findByUsername(String username); // Optional is good for handling missing users
    // but there are also a lot of query methods that are already written in JpaRepository!
}
