package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.User;
import com.laraferrer.wheretoeat.exception.UserNotFoundException;
import com.laraferrer.wheretoeat.dto.PatchDTO;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User addUser(User user);
    User modifyUser(long userId, User user) throws UserNotFoundException;
    void patchUser(long userId, PatchDTO patchDTO) throws UserNotFoundException;
    void deleteUserById(long userId) throws UserNotFoundException;
}
