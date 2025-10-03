package com.BookMyPooja.PoojaServices.controller;

import com.BookMyPooja.PoojaServices.dto.ProfileDTO;
import com.BookMyPooja.PoojaServices.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService; // make it final

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{userId}")
    public ProfileDTO getProfile(@PathVariable Long userId) {
        return profileService.getProfileByUserId(userId);
    }
}
