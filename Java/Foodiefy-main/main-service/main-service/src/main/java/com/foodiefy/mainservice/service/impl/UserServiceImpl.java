package com.foodiefy.mainservice.service.impl;

import com.foodiefy.mainservice.dto.UserDto;
import com.foodiefy.mainservice.model.User;
import com.foodiefy.mainservice.repository.UserRepository;
import com.foodiefy.mainservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user -> {

            UserDto userDto = UserDto.builder()
                    .fullName(user.getFullName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .role(user.getRole())
                    .build();

            userDtos.add(userDto);
        });

        return userDtos;
    }

    @Override
    public UserDto getUserById(long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }

        return UserDto.builder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    @Override
    public String addUser(UserDto userDto) {

        User user = new User();

        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        userRepository.save(user);

        return "User added successfully";
    }

    @Override
    public String updateUser(UserDto userDto, long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.save(user);

        return "User updated successfully";
    }

    @Override
    @Transactional
    public String deleteUser(long id) {
        userRepository.deleteById(id);

        return "User deleted successfully";
    }



}
