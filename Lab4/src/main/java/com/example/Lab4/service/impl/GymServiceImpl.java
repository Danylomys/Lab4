package com.example.Lab4.service.impl;

import com.example.Lab4.dto.GymDTO;
import com.example.Lab4.entity.Gym;
import com.example.Lab4.exceptions.BadRequestException;
import com.example.Lab4.repository.GymRepository;
import com.example.Lab4.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {

    private final GymRepository gymRepository;

    @Override
    public GymDTO createGym(GymDTO gymDTO) {
        Gym gym = new Gym();
        gym.setName(gymDTO.getName());
        gym.setAddress(gymDTO.getAddress());

        gymRepository.save(gym);
        return GymDTO.fromGym(gym);
    }

    @Override
    public GymDTO getGymById(Long id) {
        Gym gym = gymRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Gym not found with id: " + id));
        return GymDTO.fromGym(gym);
    }

    @Override
    public List<GymDTO> getAllGyms() {
        return gymRepository.findAll().stream()
                .map(GymDTO::fromGym)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGym(Long id) {
        gymRepository.deleteById(id);
    }
}
