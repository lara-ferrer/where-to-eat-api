package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.User;
import com.laraferrer.wheretoeat.dto.UserDTO;
import com.laraferrer.wheretoeat.exception.CityNotFoundException;
import com.laraferrer.wheretoeat.exception.UserNotFoundException;
import com.laraferrer.wheretoeat.dto.PatchDTO;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User addUser(UserDTO userDTO) throws CityNotFoundException;
    User findUsernameById(long id) throws UserNotFoundException;
    User modifyUser(long userId, User user) throws UserNotFoundException;
    void patchUser(long userId, PatchDTO patchDTO) throws UserNotFoundException;
    void deleteUserById(long userId) throws UserNotFoundException;
}
