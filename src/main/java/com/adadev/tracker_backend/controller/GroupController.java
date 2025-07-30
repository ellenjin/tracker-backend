package com.adadev.tracker_backend.controller;
import java.util.List;
import com.adadev.tracker_backend.repository.GroupRepository;
import com.adadev.tracker_backend.model.Group;
import com.adadev.tracker_backend.service.GroupService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @PostMapping
    public Group addOneGroup(@RequestBody Group group) {
        return groupService.addOneGroup(group);
    }
    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }
    @GetMapping("/{groupId}")
    public Group findOneGroup(@PathVariable Integer groupId) {
        return groupService.findOneGroup(groupId);
    }
    
    @DeleteMapping("/groups/{groupId}")
    public Group deleteGroup(@PathVariable("groupId") Integer groupId){
        return this.groupService.deleteGroup(groupId);
    }
}
