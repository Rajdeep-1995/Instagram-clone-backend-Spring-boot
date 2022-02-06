package com.instagramclone.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class SignUpDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Size(max = 10,min = 10)
    private String phoneNumber;

    @NotEmpty
    @Size(min = 5,max = 20)
    private String username;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String gender;

    @NotEmpty
    @Size(min = 6,max = 12)
    private String password;


    //private Date birthDate;
}
