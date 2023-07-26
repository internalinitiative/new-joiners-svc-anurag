package com.example.GitHubCopilot.Service;

import com.example.GitHubCopilot.DtoValidator.EmpValidation;
import com.example.GitHubCopilot.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmpService {

    public Employee addEmployee(EmpValidation emp);
    //public Employee addEmployee(Employee emp);
    public String removeEmployee(int id);
    public Optional<Employee> findEmpByID(int id);
    public List<Employee> getAllEmployee();

    public Employee updateEmployee(EmpValidation emp);
}
