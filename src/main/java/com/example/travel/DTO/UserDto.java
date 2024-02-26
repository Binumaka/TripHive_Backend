package com.example.travel.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private Integer id;

    @NotNull
    private String email;

    @NotNull
    private String Username;

    @NotNull
    private String password;
}