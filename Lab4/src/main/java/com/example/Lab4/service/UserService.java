package com.example.Lab4.service;

import com.example.Lab4.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getUsers();
    UserDTO updateUser(UserDTO userDTO);
    void deleteById(Long id);
}
