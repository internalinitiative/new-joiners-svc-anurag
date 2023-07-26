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
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eid;

    @Column(name = "emp_name")
    private String ename;

    @Column(name = "emp_mailid")
    private String eemail;

    @Column(name ="emp_mobile")
    private String emob;

    @Column(name = "emp_salary")
    private int esalary;
}
