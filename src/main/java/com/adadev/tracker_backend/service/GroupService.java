package com.adadev.tracker_backend.service;

import com.adadev.tracker_backend.exception.GroupNotFoundException;
import com.adadev.tracker_backend.model.Group;
import com.adadev.tracker_backend.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
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
}
