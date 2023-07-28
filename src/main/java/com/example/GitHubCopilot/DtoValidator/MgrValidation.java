package com.example.GitHubCopilot.DtoValidator;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MgrValidation {

        private int id;

        @NotNull(message = "manager name should not be null")
        @NotBlank(message = " manager name can not be blank")
        private String name;

        @NotNull(message = "manager email should not be null")
        @NotBlank(message = " manager email can not be blank")
        @Email
        private String email;

        @NotNull
        @Pattern(regexp = "^\\d{10}$" , message = "invalid mobile number entered")
        private String mobile;

        @NotBlank(message = " department can not be blank")
        private String department;
}
