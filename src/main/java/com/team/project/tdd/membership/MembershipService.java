package com.team.project.tdd.membership;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService {

  private final MembershipRepository membershipRepository;

  public Membership addMembership(final String userId, final MembershipType membershipType, final Integer point) {
    final Membership result = membershipRepository.findByUserIdAndMembershipType(userId, membershipType);
    if (result != null) {
      throw new MembershipException(MembershipErrorResult.MEMBERSHIP_ALREADY_EXISTS);
    }

    return null;
  }

}
