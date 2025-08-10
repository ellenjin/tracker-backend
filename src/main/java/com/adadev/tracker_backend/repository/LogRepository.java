package com.adadev.tracker_backend.repository;

import com.adadev.tracker_backend.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
    @Query("SELECT l FROM Log l WHERE l.user.id = :userId AND l.group.Id = :groupId")
    Log findByUser_IdAndGroup_Id(Integer userId, Integer groupId);
}
