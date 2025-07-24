package com.adadev.tracker_backend.repository;

import com.adadev.tracker_backend.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    // You can add custom query methods here, like:
//    Group findByName(String name);
}
