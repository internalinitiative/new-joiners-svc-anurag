package com.example.GitHubCopilot.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
@Setter
@Getter
@ToString
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mid;
    @Column(name = "manager_name")
    private String mname;
    @Column(name="manager_email")
    private String memail;
    @Column(name = "manager_mobile")
    private String mmob;
    @Column(name="department")
    private String mdepartment;
}
