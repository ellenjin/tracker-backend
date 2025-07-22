package com.adadev.tracker_backend.controller;

import java.util.List;

import com.adadev.tracker_backend.exception.UserNotFoundException;
import com.adadev.tracker_backend.model.User;
import com.adadev.tracker_backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5432") // For now, to allow for front end to reach backend when hosted locally
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    // Get specific user by id
    // ADJUST SO THAT IT CAN BE BY USERNAME AS WELL (check the {} part for type, then go down routes for id vs username)
    @GetMapping("/users/{id}")
    public User findOneUser(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id", id)); // Not sure this is actually being thrown right now
        return user;
    }
    // Add one user
    @PostMapping("/users")
    public User addOneUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }
}
