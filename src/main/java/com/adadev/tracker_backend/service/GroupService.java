package com.adadev.tracker_backend.service;

import com.adadev.tracker_backend.exception.GroupNotFoundException;
import com.adadev.tracker_backend.model.Group;
import com.adadev.tracker_backend.model.User;
import com.adadev.tracker_backend.repository.GroupRepository;
import com.adadev.tracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    // Create new group
    public Group addOneGroup(Group group){
        return groupRepository.save(group);
    }

    // Read all groups
    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    // Read one group by id 
    public Group findOneGroup(Integer groupId){
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("ID", Integer.toString(groupId)));
    }

    // Delete one group by id - NEED TO CASCADE TO REMOVE ALL ASSOCIATED USERS?
    public Group deleteGroup(Integer groupId){
        Optional<Group> groupToDeleteOptional = this.groupRepository.findById(groupId);

        // The group doesn't exist
        if(!groupToDeleteOptional.isPresent()){
            return null;
        }
        
        Group groupToDelete = groupToDeleteOptional.get();
        this.groupRepository.delete(groupToDelete);

        return groupToDelete;
    }

    public List<User> getGroupUsers(Integer groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        return userRepository.findAllByGroupsContains(group);
    }
}
