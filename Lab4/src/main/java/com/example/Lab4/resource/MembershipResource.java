package com.example.Lab4.resource;

import com.example.Lab4.dto.MembershipDTO;
import com.example.Lab4.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/memberships")
public class MembershipResource {

    private final MembershipService membershipService;

    @PostMapping
    public MembershipDTO createMembership(@RequestBody MembershipDTO membershipDTO) {
        return membershipService.createMembership(membershipDTO);
    }

    @GetMapping("/{id}")
    public MembershipDTO getMembershipById(@PathVariable Long id) {
        return membershipService.getMembershipById(id);
    }

    @GetMapping
    public List<MembershipDTO> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    @PutMapping
    public MembershipDTO updateMembership(@RequestBody MembershipDTO membershipDTO) {
        return membershipService.updateMembership(membershipDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMembership(@PathVariable Long id) {
        membershipService.deleteMembershipById(id);
    }
}
