package com.adadev.tracker_backend.model;
import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer groupId; // probably don't need to label these as "group__". When we reference them, this should
    // already be clear via group.id -- redundant to have 'group' in the name as well.
    
    private String groupName;
    private String groupPicture; 
    private String groupDescription; 

    // Hibernate needs entities to have a no-arg constructor, but it doesn't have to be public.
    private Group() {
    }

    public Group(String name, String description, String picture) {
        this.groupName = name;
        this.groupPicture = picture;
        this.groupDescription = description;
    }

    public Integer getGroupId(){
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupPicture() {
        return this.groupPicture;
    }

    public String getGroupDescription() {
        return this.groupDescription;
    }

    // Setters to update fields if the user choose to edit group details
    public void setGroupName(String name) {
        this.groupName = name;
    }

    public void setGroupPicture(String picture) {
        this.groupPicture = picture;
    }

    public void setGroupDescription(String description) {
        this.groupDescription = description;
    }


}
