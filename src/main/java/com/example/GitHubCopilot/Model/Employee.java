package com.example.GitHubCopilot.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_mailid")
    private String email;

    @Column(name ="emp_mobile")
    private String mobile;

    @Column(name = "emp_salary")
    private int salary;
}
