package com.team.project.tdd.membership;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MembershipErrorResult {

  MEMBERSHIP_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "이미 존재하는 멤버십입니다."),
      ;


  private final HttpStatus httpStatus;
  private final String message;
}
