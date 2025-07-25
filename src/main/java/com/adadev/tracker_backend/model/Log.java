package com.adadev.tracker_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    private String title;

    private Integer frequencyCount; //number of times

    @Enumerated(EnumType.STRING)
    private FrequencyUnit frequencyUnit; // Custom enum type: DAY/ WEEK/ MONTH
    private Integer score;
    private String skillLevel;

    @Column(updatable = false)
    private LocalDateTime timeStamp;

    // Link each Log to a Group (of user ids)
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @PrePersist
    protected void onCreate() {
        this.timeStamp = LocalDateTime.now();
    }

    // Getters/setters
    public Integer getLogId() { return logId; }
    public void setLogId(Integer logId) { this.logId = logId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getFrequencyCount() {return frequencyCount; }
    public void setFrequencyCount(Integer frequencyCount) {this.frequencyCount = frequencyCount;}

    public FrequencyUnit getFrequencyUnit() { return frequencyUnit; }
    public void setFrequencyUnit(FrequencyUnit frequencyUnit) { this.frequencyUnit = frequencyUnit; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public String getSkillLevel() { return skillLevel; }
    public void setSkillLevel(String skillLevel) { this.skillLevel = skillLevel; }

    public LocalDateTime getTimeStamp() { return timeStamp; }
    public void setTimeStamp(LocalDateTime timeStamp) { this.timeStamp = timeStamp; }

    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }
}
