package com.BookMyPooja.PoojaServices.service;

import com.BookMyPooja.PoojaServices.dto.ProfileDTO;
import com.BookMyPooja.PoojaServices.entity.Provider;
import com.BookMyPooja.PoojaServices.entity.UserInfo;
import com.BookMyPooja.PoojaServices.repository.ProviderRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProviderRepository providerRepository;

    public ProfileService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public ProfileDTO getProfileByUserId(Long userId) {
        Provider provider = providerRepository.findAll().stream()
                .filter(p -> p.getUserInfo().getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        UserInfo u = provider.getUserInfo();
        return new ProfileDTO(
                u.getFirstname(),
                u.getLastname(),
                u.getCity(),
                u.getEmail(),
                u.getPhone(),
                u.getProfilePic(),
                provider.getAboutMe(),
                provider.getStatus()
        );
    }
}
