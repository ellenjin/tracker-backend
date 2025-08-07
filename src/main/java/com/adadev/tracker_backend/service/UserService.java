package com.adadev.tracker_backend.service;

import com.adadev.tracker_backend.exception.UserNotFoundException;
import com.adadev.tracker_backend.exception.UsernameConflictException;

import com.adadev.tracker_backend.model.Group;
import com.adadev.tracker_backend.model.Log;
import com.adadev.tracker_backend.model.User;
import com.adadev.tracker_backend.repository.GroupRepository;
import com.adadev.tracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

/*
Handles User specific actions
 */

@Service
public class UserService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public UserService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }
    private User getUserOrThrow(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Create new user
    public User addOneUser(User user) {
        // username validation
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UsernameConflictException(user.getUsername());
        }
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get one user by ID or username
    public User findOneUser(String identifier) {
        try { // by ID
            Integer userId = Integer.parseInt(identifier);
            return userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("ID", userId));
        } catch (NumberFormatException e) {
            return userRepository.findByUsername(identifier) // by Username
                    .orElseThrow(() -> new UserNotFoundException("username", identifier));
        }
    }
    // update a user's interests
    public void updateInterests(Integer userId, Set<String> newInterests) {
        // replace current set with new set
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.updateInterests(newInterests);
        userRepository.save(user);
    }
    /*
    Group routes
     */
    // Add user to a group
    public void addUserToGroup(Integer userId, Integer groupId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        user.getGroups().add(group);
        userRepository.save(user);
    }

    /*
    Log routes
     */
    public Set<Log> getLogs(Integer userId) {
        User user = getUserOrThrow(userId);
        return user.getLogs();
    }
}
