package com.team.project.tdd;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.team.project.tdd.membership.Membership;
import com.team.project.tdd.membership.MembershipRepository;
import com.team.project.tdd.membership.MembershipType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MembershipRepositoryTest {
  @Autowired
  private MembershipRepository membershipRepository;

  @Test
  void 멤버십등록() {
    // Given
    final Membership memberShip = Membership.builder()
        .userId("userId")
        .membershipType(MembershipType.NAVER)
        .point(10000)
        .build();

    // When
    final Membership result = membershipRepository.save(memberShip);

    // Then
    assertThat(result.getId()).isNotNull();
    assertThat(result.getUserId()).isEqualTo("userId");
    assertThat(result.getMembershipType()).isEqualTo(MembershipType.NAVER);
    assertThat(result.getPoint()).isEqualTo(10000);

  }

  @Test
  void 멤버십이존재하는지테스트() {
    // Given
    final Membership memberShip = Membership.builder()
        .userId("userId")
        .membershipType(MembershipType.NAVER)
        .point(10000)
        .build();

    // When
    membershipRepository.save(memberShip);
    final Membership findResult = membershipRepository.findByUserIdAndMembershipType ("userId", MembershipType.NAVER);

    // Then
    assertThat(findResult).isNotNull();
    assertThat(findResult.getId()).isNotNull();
    assertThat(findResult.getUserId()).isEqualTo("userId");
    assertThat(findResult.getMembershipType()).isEqualTo(MembershipType.NAVER);
    assertThat(findResult.getPoint()).isEqualTo(10000);

  }
}
