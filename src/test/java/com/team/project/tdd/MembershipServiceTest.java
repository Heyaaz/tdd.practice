package com.team.project.tdd;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import com.team.project.tdd.membership.Membership;
import com.team.project.tdd.membership.MembershipException;
import com.team.project.tdd.membership.MembershipRepository;
import com.team.project.tdd.membership.MembershipService;
import com.team.project.tdd.membership.MembershipType;
import com.team.project.tdd.membership.MembershipErrorResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MembershipServiceTest {

  @InjectMocks
  private MembershipService target;

  @Mock
  private MembershipRepository membershipRepository;


  private final String userId = "userId";
  private final MembershipType membershipType = MembershipType.NAVER;
  private final Integer point = 10000;

  @Test
  void 멤버십등록실패_이미존재() {
    // Given
    doReturn(Membership.builder().build()).when(membershipRepository).findByUserIdAndMembershipType(userId, membershipType);

    // When
    final MembershipException result = assertThrows(MembershipException.class, () -> {
      target.addMembership(userId, membershipType, point);
    });

    // Then
    assertThat(result.getErrorResult()).isEqualTo(MembershipErrorResult.MEMBERSHIP_ALREADY_EXISTS);

  }
}
