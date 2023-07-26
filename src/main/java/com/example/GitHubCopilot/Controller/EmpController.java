package com.example.GitHubCopilot.Controller;

import com.example.GitHubCopilot.DtoValidator.EmpValidation;
import com.example.GitHubCopilot.Model.Employee;
import com.example.GitHubCopilot.Service.EmpService;
import com.example.GitHubCopilot.ServiceImpl.EmpServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpServiceImpl empservice;

    @RequestMapping("/home")
    public String homepage() {

        return "welcome to employee home page";
    }


    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployees(@RequestBody @Valid EmpValidation employee){

        Employee emp = empservice.addEmployee(employee);

        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeemp/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable int id){

        empservice.removeEmployee(id);
        return new ResponseEntity<String>("Remove Employee successfully",HttpStatus.ACCEPTED);
    }

    @GetMapping("/getemp/{id}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int id){

        Optional<Employee> empByID = empservice.findEmpByID(id);
        
        return new ResponseEntity<Optional<Employee>>(empByID,HttpStatus.ACCEPTED);

    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> listOfEmployee(){
        List<Employee> allEmployee = empservice.getAllEmployee();

        return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateemp/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody @Valid EmpValidation employee){

        employee.setEid(id);
        Employee updtEmp = empservice.updateEmployee(employee);
        return new ResponseEntity<>(updtEmp,HttpStatus.OK);
    }
}
