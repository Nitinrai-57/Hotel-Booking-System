package com.userservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="user_session")
public class UserSession {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne(optional = false)
@JoinColumn(name="user_id")
private User user;
@Column(name="refresh_token",nullable = true,unique = true)
private String refreshToken;
@Column(name="expiry_At",nullable = false)
private Instant expiryAt;
@Column(name="created_At",nullable = false)
private Instant createdAt=Instant.now();

}
