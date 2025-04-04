package com.team.project.tdd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity @Table @Builder @Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberShip {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private MembershipType membershipType;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  @ColumnDefault("0")
  private Integer point;

  @Column(nullable = false, length = 20, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(length = 20)
  @UpdateTimestamp
  private LocalDateTime updateAt;

}
