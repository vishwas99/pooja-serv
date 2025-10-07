package com.BookMyPooja.PoojaServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PROVIDERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Long providerId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    private String about_me;
    private String status;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return Objects.equals(providerId, provider.providerId) && Objects.equals(user, provider.user) && Objects.equals(about_me, provider.about_me) && Objects.equals(status, provider.status) && Objects.equals(createdAt, provider.createdAt) && Objects.equals(updatedAt, provider.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerId, user, about_me, status, createdAt, updatedAt);
    }

    @ManyToMany
    @JoinTable(
            name = "provider_services",
            joinColumns = @JoinColumn(name = "provider_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    Set<Service> services = new HashSet<>();

}
