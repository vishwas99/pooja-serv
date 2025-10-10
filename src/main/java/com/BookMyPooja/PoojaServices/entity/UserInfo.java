package com.BookMyPooja.PoojaServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInfoId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 50, nullable = false)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @Column(length = 20, nullable = false)
    private String phone;

    private String email;

    private String address;

    @Column(length = 50, nullable = false)
    private String city;

    @Lob
    private byte[] profilePic;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    protected void updateTimestamps() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        updatedAt = LocalDateTime.now();
    }
}
