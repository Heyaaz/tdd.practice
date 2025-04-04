package com.team.project.tdd;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<MemberShip, Long> {

  MemberShip findByUserIdAndMembershipType(String userId, MembershipType membershipType);
}
