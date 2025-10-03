package com.BookMyPooja.PoojaServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "providers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserInfo userInfo;

    private String aboutMe;
    private String status;
    private String createdAt;
    private String updatedAt;
}

