package com.team.project.tdd;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    final MemberShip memberShip = MemberShip.builder()
        .userId("userId")
        .membershipType(MembershipType.NAVER)
        .point(10000)
        .build();

    // When
    final MemberShip result = membershipRepository.save(memberShip);

    // Then
    assertThat(result.getId()).isNotNull();
    assertThat(result.getUserId()).isEqualTo("userId");
    assertThat(result.getMembershipType()).isEqualTo(MembershipType.NAVER);
    assertThat(result.getPoint()).isEqualTo(10000);

  }
}
