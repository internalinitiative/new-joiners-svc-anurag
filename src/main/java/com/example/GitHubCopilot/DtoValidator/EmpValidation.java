package com.example.GitHubCopilot.DtoValidator;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpValidation {

    private int eid;

    @NotNull(message = "employee name should not be null")
    @NotBlank(message = " name can not be blank")
    private String ename;

    @NotNull(message = "employee email should not be null")
    @NotBlank(message = " email can not be blank")
    @Email
    private String eemail;

    @NotNull
    @Pattern(regexp = "^\\d{10}$" , message = "invalid mobile number entered")
    private String emob;

    private int esalary;
}
