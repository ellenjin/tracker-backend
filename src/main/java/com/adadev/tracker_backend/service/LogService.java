package com.adadev.tracker_backend.service;

import com.adadev.tracker_backend.exception.UserNotFoundException;
import com.adadev.tracker_backend.model.Log;
import com.adadev.tracker_backend.model.Group;
import com.adadev.tracker_backend.model.User;
import com.adadev.tracker_backend.repository.LogRepository;
import com.adadev.tracker_backend.repository.GroupRepository;
import com.adadev.tracker_backend.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;

// This file keeps business logic out of the controller and validates if a log exists before updating or deleting

@Service
public class LogService {

    private final LogRepository logRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public LogService(LogRepository logRepository, GroupRepository groupRepository, UserRepository userRepository) {
        this.logRepository = logRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Log addNewLog(Log log) {
        Group group = null;
        if (log.getGroup() != null) {
            Integer groupId = log.getGroup().getId();
            group = groupRepository.findById(groupId)
                    .orElseThrow(() -> new RuntimeException("Group not found with id: " + groupId));
        }

        log.setGroup(group);
        return logRepository.save(log);
    }

    //Get all logs
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    // Get log by ID
    public Log findOneLog(Integer logId) {
        return logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log with ID: " + logId + " not found"));
    }

    public Log updateLog(Integer logId, Log updatedLog) {
        Log existingLog = findOneLog(logId);

        existingLog.setTitle(updatedLog.getTitle());
        existingLog.setFrequencyCount(updatedLog.getFrequencyCount());
        existingLog.setFrequencyUnit(updatedLog.getFrequencyUnit());
        existingLog.setScore(updatedLog.getScore());
        existingLog.setSkillLevel(updatedLog.getSkillLevel());
        existingLog.setGroup(updatedLog.getGroup());

        return logRepository.save(existingLog);
    }

    // Delete log by ID
    public void deleteLog(Integer logId) {
        if (!logRepository.existsById(logId)) {
            throw new RuntimeException("Log with ID: " + logId + " not found");
        }
        logRepository.deleteById(logId);
    }
}