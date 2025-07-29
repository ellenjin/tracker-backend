package com.adadev.tracker_backend.service;

import com.adadev.tracker_backend.model.Log;
import com.adadev.tracker_backend.repository.LogRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// This file keeps business logic out of the controller and validates if a log exists before updating or deleting

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    // Create new log
    // NOTE: should add in username validation (x characters long, not already in db, etc.)
    public Log addNewLog(Log log) {
        return logRepository.save(log);
    }

    //Get all logs
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    // Get log by ID
    // Add logic to search by either ID or username (check if value = int or alpha)
    public Log findOneLog(Integer logId) {
        return logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log with ID: " + logId + " not found"));
    }

    // Update log by ID
    // Do any of these need to handle null fields conditionally?
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