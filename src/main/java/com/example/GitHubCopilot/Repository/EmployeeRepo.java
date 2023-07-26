package com.example.GitHubCopilot.Repository;

import com.example.GitHubCopilot.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee , Integer> {

}
