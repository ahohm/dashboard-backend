package com.akkurad.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerDto {

    private String username;
    private String phoneNumber;
    private String affiliation;
    private String imageUrl = "";
    private String password;
    private String email;
    private boolean mailVerified = false;
}

