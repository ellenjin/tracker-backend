package com.adadev.tracker_backend.controller;
import java.util.List;
import java.util.Set;

import com.adadev.tracker_backend.dto.AddUserToGroupRequest;
import com.adadev.tracker_backend.dto.UpdateInterestsRequest;
import com.adadev.tracker_backend.model.User;
import com.adadev.tracker_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/*
Note: Controller vs Service: Controller should only have logic related to REST request/response!
All business logic goes into service.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User addOneUser(@Valid @RequestBody User user) {
        return userService.addOneUser(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // via either username OR id
    @GetMapping("/{identifier}")
    public User findOneUser(@PathVariable String identifier) {
            return userService.findOneUser(identifier);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return("Deleted user " + userId);
    }

    @PutMapping("/{userId}/add-to-group")
    public String addUserToGroup(
            @PathVariable Integer userId,
            @RequestBody AddUserToGroupRequest request) {
        userService.addUserToGroup(userId, request.getGroupId());
        return "User added to group " + request.getGroupId();
    }

    @PutMapping("/{userId}/interests")
    public Set<String> updateInterests(
            @PathVariable Integer userId,
            @RequestBody UpdateInterestsRequest request) {
        userService.updateInterests(userId, request.getInterests());
        return request.getInterests();
    }

    @PutMapping("/{userId}/add-friend/{friendId}")
    public String addFriend(
            @PathVariable Integer userId,
            @PathVariable Integer friendId) {
        userService.addFriend(userId, friendId);
        return ("User ID " + friendId + " added to friends");
    }

    @PutMapping("/{userId}/remove-friend/{friendId}")
    public String removeFriend(@PathVariable Integer userId, @PathVariable Integer friendId) {
        userService.removeFriend(userId, friendId);
        return("Removed User " + friendId + " from friends");
    }
}
