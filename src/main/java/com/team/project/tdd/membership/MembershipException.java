package com.team.project.tdd.membership;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MembershipException extends RuntimeException{

  private final MembershipErrorResult errorResult;

}
