package com.adadev.tracker_backend.dto;

public class AddUserToGroupRequest {
    private Integer userId;
    private Integer groupId;

    public AddUserToGroupRequest() { // Need no argument constructor
    }

    public AddUserToGroupRequest(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
