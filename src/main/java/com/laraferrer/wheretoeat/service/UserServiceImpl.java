package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.City;
import com.laraferrer.wheretoeat.domain.User;
import com.laraferrer.wheretoeat.dto.UserDTO;
import com.laraferrer.wheretoeat.exception.CityNotFoundException;
import com.laraferrer.wheretoeat.exception.UserNotFoundException;
import com.laraferrer.wheretoeat.repository.CityRepository;
import com.laraferrer.wheretoeat.repository.UserRepository;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUsernameById(long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        return user;
    }

    @Override
    public User addUser(UserDTO userDTO) throws CityNotFoundException {
        City city = cityRepository.findById(userDTO.getCityId())
                .orElseThrow(CityNotFoundException::new);

        User user = new User();
        user.setId(user.getId());
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setTelephone(userDTO.getTelephone());
        user.setAddress(userDTO.getAddress());
        user.setAge(userDTO.getAge());
        user.setCreationDate(userDTO.getCreationDate());
        user.setCity(city);

        return userRepository.save(user);
    }

    @Override
    public User modifyUser(long userId, User user) throws UserNotFoundException {
        User newUser = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setTelephone(user.getTelephone());
        newUser.setAge(user.getAge());

        return userRepository.save(newUser);
    }

    @Override
    public void patchUser(long userId, PatchDTO patchDTO) throws UserNotFoundException {
        User newUser = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        if (patchDTO.getKey().equals("username")) {
            newUser.setUsername(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("name")) {
            newUser.setName(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("surname")) {
            newUser.setSurname(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("email")) {
            newUser.setEmail(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("telephone")) {
            newUser.setTelephone(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("age")) {
            newUser.setAge(Integer.parseInt(patchDTO.getValue()));
        }

        userRepository.save(newUser);
    }

    @Override
    public void deleteUserById(long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}
