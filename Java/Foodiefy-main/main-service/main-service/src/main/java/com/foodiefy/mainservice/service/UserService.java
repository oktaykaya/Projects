package com.foodiefy.mainservice.service;


import com.foodiefy.mainservice.dto.UserDto;

import java.util.List;

public interface UserService {
    //crud operations -> create, read, update, delete

    List<UserDto> getAllUsers();

    UserDto getUserById(long id);

    String addUser(UserDto userDto);

    String updateUser(UserDto userDto, long id);

    String deleteUser(long id);

}
