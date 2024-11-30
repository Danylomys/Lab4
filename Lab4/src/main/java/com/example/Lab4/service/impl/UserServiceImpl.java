package com.example.Lab4.service.impl;

import com.example.Lab4.dto.UserDTO;
import com.example.Lab4.entity.Membership;
import com.example.Lab4.entity.User;
import com.example.Lab4.exceptions.BadRequestException;
import com.example.Lab4.repository.MembershipRepository;
import com.example.Lab4.repository.UserRepository;
import com.example.Lab4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MembershipRepository membershipRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        userRepository.save(user);

        if (userDTO.getMembershipId() != null) {
            Optional<Membership> membership = membershipRepository.findById(userDTO.getMembershipId());
            membership.ifPresent(user::setMembership);
        }

        userRepository.save(user);

        return UserDTO.fromUser(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("User not found"));
        return UserDTO.fromUser(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::fromUser)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getUserId()).orElseThrow(() -> new BadRequestException("User not found"));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        if (userDTO.getMembershipId() != null) {
            Optional<Membership> membership = membershipRepository.findById(userDTO.getMembershipId());
            membership.ifPresent(user::setMembership);
        }

        userRepository.save(user);

        return UserDTO.fromUser(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
