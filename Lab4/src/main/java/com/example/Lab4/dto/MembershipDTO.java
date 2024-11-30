package com.example.Lab4.dto;

import com.example.Lab4.entity.Amenity;
import com.example.Lab4.entity.Membership;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembershipDTO {
    private Long id;
    private String membershipType;
    private double price;
    private List<Long> amenityIds;


    public static MembershipDTO fromMembership(Membership membership) {
        return new MembershipDTO(
                membership.getId(),
                membership.getMembershipType(),
                membership.getPrice(),
                membership.getAmenities().stream()
                        .map(Amenity::getAmenityId)
                        .collect(Collectors.toList())
        );
    }
}
