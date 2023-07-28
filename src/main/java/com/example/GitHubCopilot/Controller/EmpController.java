package com.example.GitHubCopilot.Controller;

import com.example.GitHubCopilot.DtoValidator.EmpValidation;
import com.example.GitHubCopilot.Model.Employee;
import com.example.GitHubCopilot.Service.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmpController {

    private EmpService empService;

    @Autowired
    public EmpController(EmpService empService){
        this.empService=empService;
    }

    @RequestMapping("/home")
    public String homepage() {

        return "welcome to employee home page";
    }


    @PostMapping
    public ResponseEntity<Employee> addEmployees(@RequestBody @Valid EmpValidation employee){

        Employee emp = empService.addEmployee(employee);

        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable int id){

        empService.removeEmployee(id);
        return new ResponseEntity<String>("Remove Employee successfully",HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int id){

        Optional<Employee> empByID = empService.findEmpByID(id);
        
        return new ResponseEntity<Optional<Employee>>(empByID,HttpStatus.ACCEPTED);

    }

    @GetMapping
    public ResponseEntity<List<Employee>> listOfEmployee(){
        List<Employee> allEmployee = empService.getAllEmployee();

        return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Employee>> updateEmployee(@PathVariable int id,@RequestBody @Valid EmpValidation employee){

        employee.setId(id);
        Optional<Employee> updtEmp = empService.updateEmployee(employee);
        return new ResponseEntity<>(updtEmp,HttpStatus.OK);
    }
}
