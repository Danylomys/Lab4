package com.example.Lab4.service;

import com.example.Lab4.dto.MembershipDTO;

import java.util.List;

public interface MembershipService {
    MembershipDTO createMembership(MembershipDTO membershipDTO);
    MembershipDTO getMembershipById(Long id);
    List<MembershipDTO> getAllMemberships();
    void deleteMembershipById(Long id);
    MembershipDTO updateMembership(MembershipDTO membershipDTO);
}
