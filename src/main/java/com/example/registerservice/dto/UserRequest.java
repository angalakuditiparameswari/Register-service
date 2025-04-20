package com.example.registerservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    @NotBlank(message = "username (email) is required")
    @Email(message = "username must be valid email")
    private String username;

    @NotBlank(message = "password is required")
    @Size(max = 4,min = 4,message = "password must be exactly 4 characters")
    /*@Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
            message = "Password must contain at least one uppercase, one lowercase letter, and one digit"
    )*/
    private String password;

}
