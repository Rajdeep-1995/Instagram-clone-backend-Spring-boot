package com.instagramclone.payload.authDto;

import lombok.Data;

@Data
public class SignInDto {
    private String phoneNumberOrEmailOrUsername;
    private String password;
}
