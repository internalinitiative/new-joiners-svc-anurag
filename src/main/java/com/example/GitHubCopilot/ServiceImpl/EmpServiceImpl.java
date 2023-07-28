package com.example.GitHubCopilot.ServiceImpl;

import com.example.GitHubCopilot.DtoValidator.EmpValidation;
import com.example.GitHubCopilot.Model.Employee;
import com.example.GitHubCopilot.Repository.EmployeeRepo;
import com.example.GitHubCopilot.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmpServiceImpl(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }

    @Override
    public Employee addEmployee(EmpValidation empValidation) {
       Employee employee =
               Employee.build(empValidation.getId(),empValidation.getName(),empValidation.getEmail(),empValidation.getMobile(),empValidation.getSalary());

       return employeeRepo.save(employee);
   }

//    @Override
//    public Employee addEmployee(Employee emp) {
//        Employee employee = employeeRepo.save(emp);
//        return employee;
//    }

    @Override
    public String removeEmployee(int id) {

        employeeRepo.deleteById(id);
        return "employee deleted successfully";
    }

    @Override
    public Optional<Employee> findEmpByID(int id) {

        Optional<Employee> empById = employeeRepo.findById(id);
        if(empById.isPresent())
            return empById;
        else
            return Optional.empty();

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> getAllEmp = employeeRepo.findAll();
        return getAllEmp;
    }

    @Override
    public Optional<Employee> updateEmployee(EmpValidation emp) {

        Optional<Employee> empdb = this.employeeRepo.findById(emp.getId());
        if(empdb.isPresent()){
            //System.out.println("in if "+empdb.isPresent());
            Employee empUpdt = empdb.get();
            empUpdt.setId(emp.getId());
            empUpdt.setEmail(emp.getEmail());
            empUpdt.setMobile(emp.getMobile());
            empUpdt.setName(emp.getName());
            empUpdt.setSalary(emp.getSalary());
            return Optional.of(employeeRepo.save(empUpdt));
        }

        return Optional.empty();
    }
}
