package com.example.GitHubCopilot.Service;

import com.example.GitHubCopilot.DtoValidator.EmpValidation;
import com.example.GitHubCopilot.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmpService {

     Employee addEmployee(EmpValidation emp);
    //public Employee addEmployee(Employee emp);
     String removeEmployee(int id);
     Optional<Employee> findEmpByID(int id);
     List<Employee> getAllEmployee();

    public Optional<Employee> updateEmployee(EmpValidation emp);
}
