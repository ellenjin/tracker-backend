package com.adadev.tracker_backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import com.adadev.tracker_backend.model.Group;

import java.time.LocalDateTime;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer logId;

    private String title;

    private Integer frequencyCount; //number of times

    @Enumerated(EnumType.STRING)
    private FrequencyUnit frequencyUnit; // Custom enum type: DAY/ WEEK/ MONTH

    private Integer score;

    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel; //Custom enum: BEGINNER/ INTERMEDIATE/ ADVANCED

    private Integer checkInCount;

    private Boolean wantsPartner;

    private String partnerName;

//    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime timeStamp;

    // Link each Log to a Group (interest group)
    @ManyToOne
    @JoinColumn(name = "groupId", nullable = false)
    private Group group;

    @PrePersist
    protected void onCreate() {
        this.timeStamp = LocalDateTime.now();
    }

    private Log() {}

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

    public SkillLevel getSkillLevel() { return skillLevel; }
    public void setSkillLevel(SkillLevel skillLevel) { this.skillLevel = skillLevel; }

    public Integer getCheckInCount() { return checkInCount; }
    public void setCheckInCount(Integer checkInCount) { this.checkInCount = checkInCount; }

    public Boolean getWantsPartner() { return wantsPartner; }
    public void setWantsPartner(Boolean wantsPartner) { this.wantsPartner = wantsPartner; }

    public String getPartnerName() { return partnerName; }
    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }

    public LocalDateTime getTimeStamp() { return timeStamp; }
    public void setTimeStamp(LocalDateTime timeStamp) { this.timeStamp = timeStamp; }

    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }
}


//example field body for front end:
//{
//  "title": "Walk Tracker",
//  "frequencyCount": 5,
//  "frequencyUnit": "WEEK",
//  "score": 3,
//  "skillLevel": "INTERMEDIATE",
//  "checkInCount": 0,
//  "wantsPartner": true,
//  "partnerName": "Jamie",
//  "group": {
//    "groupId": 2
//  }
//}