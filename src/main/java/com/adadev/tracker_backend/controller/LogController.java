package com.adadev.tracker_backend.controller;

import com.adadev.tracker_backend.model.Log;
import com.adadev.tracker_backend.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Note: Controller vs Service: Controller should only have logic related to REST request/response!
All business logic goes into service.
 */

@RestController
@RequestMapping("/logs")

public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }
    @PostMapping
    public Log addNewLog(@RequestBody Log log) {
        return logService.addNewLog(log);
    }

    @GetMapping
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/{logId}")
    public Log findOneLog(@PathVariable Integer logId) {
        return logService.findOneLog(logId);
    }

    @PutMapping("/{logId}")
    public Log updateLog(@PathVariable Integer logId, @RequestBody Log updatedLog) {
        return logService.updateLog(logId, updatedLog);
    }

    @DeleteMapping("/{logId}")
    public void deleteLog(@PathVariable Integer logId) {
        logService.deleteLog(logId);
    }

    @GetMapping("/user/{userId}/group/{groupId}")
    public Log getLogForUserInGroup(@PathVariable Integer userId, @PathVariable Integer groupId) {
        return logService.getUserLogForGroup(userId, groupId);
    }
}
