package com.adadev.tracker_backend.service;

import com.adadev.tracker_backend.exception.UserNotFoundException;
import com.adadev.tracker_backend.model.Group;
import com.adadev.tracker_backend.model.User;
import com.adadev.tracker_backend.repository.GroupRepository;
import com.adadev.tracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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
    // Create new user
    // NOTE: should add in username validation (x characters long, not already in db, etc.)
    public User addOneUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get one user by ID or username
    // Add logic to search by either ID or username (check if value = int or alpha)
    public User findOneUser(String identifier) {
        try {
            Integer userId = Integer.parseInt(identifier);
            return userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("ID", userId));
        } catch (NumberFormatException e) {
            return userRepository.findByUsername(identifier)
                    .orElseThrow(() -> new UserNotFoundException("username", identifier));
        }
    }
    public void addUserToGroup(Integer userId, Integer groupId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        user.getGroups().add(group);
        userRepository.save(user);
    }
}
