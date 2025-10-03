package com.BookMyPooja.PoojaServices.repository;

import com.BookMyPooja.PoojaServices.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Optional<Provider> findByUserInfo_UserId(Long userId);
}

