package com.adadev.tracker_backend.controller;
import java.util.List;
import com.adadev.tracker_backend.dto.AddUserToGroupRequest;
import com.adadev.tracker_backend.model.User;
import com.adadev.tracker_backend.service.UserService;
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
    public User addOneUser(@RequestBody User user) {
        return userService.addOneUser(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User findOneUser(@PathVariable Integer userId) {
        return userService.findOneUser(userId);
    }

    @PostMapping("/{userId}/add-to-group")
    public String addUserToGroup(
            @PathVariable Integer userId,
            @RequestBody AddUserToGroupRequest request) {
        userService.addUserToGroup(userId, request.getGroupId());
        return "User added to group " + request.getGroupId();
    }
}
