package com.example.Week2HWSpringMVC.SpringMVCWeek2HW.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DeptDTO {

    private Long id;
    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String title;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 10)
    private String createdAt;

    @Email(message = "Email should be valid email")
    private String email;
    private String password;
}
