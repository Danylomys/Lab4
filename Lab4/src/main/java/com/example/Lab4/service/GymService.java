package com.example.Lab4.service;

import com.example.Lab4.dto.GymDTO;

import java.util.List;

public interface GymService {
    GymDTO createGym(GymDTO gymDTO);
    GymDTO getGymById(Long id);
    List<GymDTO> getAllGyms();
    void deleteGym(Long id);
}
