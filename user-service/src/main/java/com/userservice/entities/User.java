package com.userservice.entities;

import jakarta.persistence.*;
import jakarta.ws.rs.ext.ParamConverter;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role=Role.USER;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status=Status.ACTIVE;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt=Instant.now();

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt=Instant.now();

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    public enum Role {
        USER, ADMIN, HOTEL_OWNER
    }

    public enum Status {
        ACTIVE, INACTIVE, BLOCKED
    }
}
