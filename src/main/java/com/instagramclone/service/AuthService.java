package com.instagramclone.service;

import com.instagramclone.payload.authDto.JwtAuthResponse;
import com.instagramclone.payload.authDto.SignInDto;
import com.instagramclone.payload.authDto.SignUpDto;

public interface AuthService {
    JwtAuthResponse signIn(SignInDto signInDto);
    Boolean register(SignUpDto signUpDto);
}
