package com.instagramclone.payload.authDto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"id","fullName","profilePhoto"})
public class UserSignInResponseDto {
    private Long Id;
    private String fullName;
    private String profilePhoto;
}
