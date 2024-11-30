package com.example.Lab4.resource;

import com.example.Lab4.dto.AmenityDTO;
import com.example.Lab4.service.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/amenities")
public class AmenityResource {

    private final AmenityService amenityService;

    @PostMapping
    public AmenityDTO createAmenity(@RequestBody AmenityDTO amenityDTO) {
        return amenityService.createAmenity(amenityDTO);
    }

    @GetMapping("/{id}")
    public AmenityDTO getAmenityById(@PathVariable Long id) {
        return amenityService.getAmenityById(id);
    }

    @GetMapping
    public List<AmenityDTO> getAllAmenities() {
        return amenityService.getAllAmenities();
    }


    @DeleteMapping("/{id}")
    public void deleteAmenity(@PathVariable Long id) {
        amenityService.deleteAmenity(id);
    }
}
