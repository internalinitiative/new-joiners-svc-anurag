package com.example.GitHubCopilot.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "manager_name")
    private String name;
    @Column(name="manager_email")
    private String email;
    @Column(name = "manager_mobile")
    private String mobile;
    @Column(name="department")
    private String department;
}
