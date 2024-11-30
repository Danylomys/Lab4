package com.example.Lab4.dto;

import com.example.Lab4.entity.Gym;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GymDTO {
    private Long gymId;
    private String name;
    private String address;

    public static GymDTO fromGym(Gym gym) {
        return new GymDTO(gym.getGymId(), gym.getName(), gym.getAddress());
    }
}
