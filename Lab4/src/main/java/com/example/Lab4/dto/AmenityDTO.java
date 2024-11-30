package com.example.Lab4.dto;

import com.example.Lab4.entity.Amenity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmenityDTO {
    private Long amenityId;
    private String name;
    private double price;

    public static AmenityDTO fromAmenity(Amenity amenity) {
        return new AmenityDTO(amenity.getAmenityId(), amenity.getName(), amenity.getPrice());
    }
}
