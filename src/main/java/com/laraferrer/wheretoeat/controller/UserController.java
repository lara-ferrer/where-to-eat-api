package com.laraferrer.wheretoeat.controller;

import com.laraferrer.wheretoeat.domain.User;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import com.laraferrer.wheretoeat.service.UserService;
import com.laraferrer.wheretoeat.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = null;
        users = userService.findAllUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/{userId}")
    public ResponseEntity<User> modifyUser(@PathVariable long userId, @RequestBody User user) throws UserNotFoundException {
        User newUser = userService.modifyUser(userId, user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PatchMapping(value = "/user/{userId}")
    public ResponseEntity<Void> patchUser(@PathVariable long userId, @RequestBody PatchDTO patchDTO) throws UserNotFoundException {
        userService.patchUser(userId, patchDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId) throws UserNotFoundException {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}