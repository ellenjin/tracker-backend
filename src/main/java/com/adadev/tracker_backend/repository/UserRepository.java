package com.adadev.tracker_backend.repository;

import com.adadev.tracker_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // You can add custom query methods here, like:
    User findByUsername(String username);
    // but there are also a lot of query methods that are already written in JpaRepository!
}
