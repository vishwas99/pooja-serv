package com.BookMyPooja.PoojaServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDTO {
    private String firstname;
    private String lastname;
    private String city;
    private String email;
    private String phone;
    private String profilePic;
    private String aboutMe;
    private String status;
}
