package com.example.Lab4.resource;

import com.example.Lab4.dto.GymDTO;
import com.example.Lab4.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gyms")
public class GymResource {

    private final GymService gymService;

    @PostMapping
    public GymDTO createGym(@RequestBody GymDTO gymDTO) {
        return gymService.createGym(gymDTO);
    }

    @GetMapping("/{id}")
    public GymDTO getGymById(@PathVariable Long id) {
        return gymService.getGymById(id);
    }

    @GetMapping
    public List<GymDTO> getAllGyms() {
        return gymService.getAllGyms();
    }


    @DeleteMapping("/{id}")
    public void deleteGym(@PathVariable Long id) {
        gymService.deleteGym(id);
    }
}
