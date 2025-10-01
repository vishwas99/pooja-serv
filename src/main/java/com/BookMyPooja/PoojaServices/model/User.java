package com.BookMyPooja.PoojaServices.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "username")
    public String username;
    @Column(name = "password")
    public String password;
    @Column(name = "enabled")
    public Boolean enabled;

    @Column(name = "account_non_expired")
    public Boolean accountNonExpired;

    @Column(name = "credentials_non_expired")
    public Boolean credentialsNonExpired;

    @Column(name = "account_non_locked")
    public Boolean accountNonLocked;

    @Column(name = "roles")
    public String roles;
}
