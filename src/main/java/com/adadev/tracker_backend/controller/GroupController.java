package com.adadev.tracker_backend.controller;

import java.util.List;

import com.adadev.tracker_backend.repository.GroupRepository;
import com.adadev.tracker_backend.model.Group;
import org.springframework.web.bind.annotation.*;

public class GroupController {
    private final GroupRepository groupRepository;

    public GroupController(final GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    public List<Group> getGroups(){
        return this.groupRepository.findAll();
    }

    /* 
        move all mapping requests to the service file
    
    // Optional type returns null of the id isn't found
    @GetMapping("/groups/{groupId}")
    public Optional<Group> getOneGroup(@PathVariable("groupId") Integer groupId){
        return this.groupRepository.findById(groupId);
    }

    @PostMapping("/groups")
    public Group createNewGroup(@RequestBody Group newGroup){
        Group newGroup = this.personRepository.save(newGroup);
        return newGroup;
    }

    @PutMapping("/groups/{groupId}")
    public Group updateGroup(@PathVariable("groupId") Integer id, @RequestBody Group updatedGroup){
        Optional<Group> groupToUpdateOptional = this.groupRepository.findById(id);
        // The group doesn't exist
        if(!groupToUpdateOptional.isPresent()){
            return null
        }
        
        Group groupToUpdate = groupToUpdateOptional.get();

        if(!groupToUpdate.getName()){
            groupToUpdate.setName(updatedGroup.getName());
        }
        if(!groupToUpdate.getPicture()){
            groupToUpdate.setPicture(updatedGroup.getPicture());
        }
        if(!groupToUpdate.getDescription()){
            groupToUpdate.setDescription(updatedGroup.getDescription());
        }
        
        Group updatedGroup = this.groupRepository.save(groupToUpdate);
        return updatedGroup;
    }
    @DeleteMapping("/groups/{groupId}")
    public Group deleteGroup(@PathVariable("groupId") Integer id){
        Optional<Group> groupToDeleteOptional = this.groupRepository.findById(id);
        // The group doesn't exist
        if(!groupToUpdateOptional.isPresent()){
            return null
        }
        
        Group groupToDelete = groupToDeleteOptional.get();
        this.groupRepository.delete(groupToDelete);
        return groupToDelete;
    }
    */ 
}
