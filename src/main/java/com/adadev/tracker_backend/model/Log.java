package com.adadev.tracker_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import com.adadev.tracker_backend.model.Group;

import java.time.LocalDateTime;

@Entity
//@Table(name = "logs")
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
    @Column(updatable = false)
    private LocalDateTime timeStamp;

    // Link each Log to a Group (interest group)
    @ManyToOne(optional = true)
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = true)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference // to stop reference loop
    private User user;
    @PrePersist
    protected void onCreate() {
        this.timeStamp = LocalDateTime.now();
    }

    public Log() {}

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

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}


//example field body for front end:
//{
//        "title": "Workout Log",
//        "frequencyCount": 3,
//        "frequencyUnit": "WEEK",
//        "score": 7,
//        "skillLevel": "INTERMEDIATE",
//        "group": {
//        "id": 2}
//        }