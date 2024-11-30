package com.example.Lab4.dto;

import com.example.Lab4.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private Long membershipId;

    public static UserDTO fromUser(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getMembership() != null ? user.getMembership().getId() : null
        );
    }
}
