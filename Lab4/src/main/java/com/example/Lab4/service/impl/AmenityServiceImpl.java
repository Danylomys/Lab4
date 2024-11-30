package com.example.Lab4.service.impl;

import com.example.Lab4.dto.AmenityDTO;
import com.example.Lab4.entity.Amenity;
import com.example.Lab4.exceptions.BadRequestException;
import com.example.Lab4.repository.AmenityRepository;
import com.example.Lab4.service.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AmenityServiceImpl implements AmenityService {

    private final AmenityRepository amenityRepository;

    @Override
    public AmenityDTO createAmenity(AmenityDTO amenityDTO) {
        Amenity amenity = new Amenity();
        amenity.setName(amenityDTO.getName());
        amenity.setPrice(amenityDTO.getPrice());

        amenityRepository.save(amenity);
        return AmenityDTO.fromAmenity(amenity);
    }

    @Override
    public AmenityDTO getAmenityById(Long id) {
        Amenity amenity = amenityRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Amenity not found with id: " + id));
        return AmenityDTO.fromAmenity(amenity);
    }

    @Override
    public List<AmenityDTO> getAllAmenities() {
        return amenityRepository.findAll().stream()
                .map(AmenityDTO::fromAmenity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAmenity(Long id) {
        amenityRepository.deleteById(id);
    }
}
