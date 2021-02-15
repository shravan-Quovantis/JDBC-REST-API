package com.example.demo.controllers;

import com.example.demo.Models.User;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    //RestAPI's
    @Autowired
    private UserServices userServices;

    //Get all User handler
    @GetMapping("/users")
    public ResponseEntity<List<User>> userController() {
        List<User> userList = this.userServices.getUserList();
        if (userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(userList));
    }

    //Get single User handler
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId) {
        User user = userServices.getUserById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(user));
    }

    @GetMapping("/users/1/addresses/")

    //New User handler
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User addedUser = null;
        try {
            addedUser = this.userServices.addUser(user);
            return ResponseEntity.of(Optional.of(addedUser));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).build();
        }
    }

    //Delete User handler
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId) {
        try {
            userServices.removeUser(userId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Update Users handler
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,
                                           @PathVariable("userId") int userId) {
        try {
            this.userServices.updateUser(user, userId);
            return ResponseEntity.of(Optional.of(user));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.
                    INTERNAL_SERVER_ERROR).build();
        }
    }
}
