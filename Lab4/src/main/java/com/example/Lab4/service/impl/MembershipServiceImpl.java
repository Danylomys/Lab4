package com.example.Lab4.service.impl;

import com.example.Lab4.dto.MembershipDTO;
import com.example.Lab4.entity.Amenity;
import com.example.Lab4.entity.Membership;
import com.example.Lab4.exceptions.BadRequestException;
import com.example.Lab4.repository.AmenityRepository;
import com.example.Lab4.repository.MembershipRepository;
import com.example.Lab4.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;
    private final AmenityRepository amenityRepository;

    @Override
    public MembershipDTO createMembership(MembershipDTO membershipDTO) {
        Membership membership = new Membership();
        membership.setMembershipType(membershipDTO.getMembershipType());
        membership.setPrice(membershipDTO.getPrice());

        if (membershipDTO.getAmenityIds() != null && !membershipDTO.getAmenityIds().isEmpty()) {
            List<Amenity> amenities = amenityRepository.findAllById(membershipDTO.getAmenityIds());
            membership.setAmenities(amenities);
        }

        membershipRepository.save(membership);

        return MembershipDTO.fromMembership(membership);
    }

    @Override
    public MembershipDTO getMembershipById(Long id) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Membership not found"));
        return MembershipDTO.fromMembership(membership);
    }

    @Override
    public List<MembershipDTO> getAllMemberships() {
        return membershipRepository.findAll().stream()
                .map(MembershipDTO::fromMembership)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMembershipById(Long id) {
        membershipRepository.deleteById(id);
    }

    @Override
    public MembershipDTO updateMembership(MembershipDTO membershipDTO) {
        Membership membership = membershipRepository.findById(membershipDTO.getId())
                .orElseThrow(() -> new BadRequestException("Membership not found"));

        membership.setMembershipType(membershipDTO.getMembershipType());
        membership.setPrice(membershipDTO.getPrice());

        if (membershipDTO.getAmenityIds() != null && !membershipDTO.getAmenityIds().isEmpty()) {
            List<Amenity> amenities = amenityRepository.findAllById(membershipDTO.getAmenityIds());
            membership.setAmenities(amenities);
        }

        membershipRepository.save(membership);

        return MembershipDTO.fromMembership(membership);
    }
}
