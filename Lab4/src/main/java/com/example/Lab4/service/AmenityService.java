package com.example.Lab4.service;

import com.example.Lab4.dto.AmenityDTO;

import java.util.List;

public interface AmenityService {
    AmenityDTO createAmenity(AmenityDTO amenityDTO);
    AmenityDTO getAmenityById(Long id);
    List<AmenityDTO> getAllAmenities();
    void deleteAmenity(Long id);
}
