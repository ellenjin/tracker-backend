package com.adadev.tracker_backend.repository;

import com.adadev.tracker_backend.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
    // You can add custom query methods here, like:
    Log findByTitle(String title);
    // but there are also a lot of query methods that are already written in JpaRepository!
}
