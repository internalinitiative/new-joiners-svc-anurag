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

    @Autowired
    private EmployeeRepo emprepo;

    @Override
    public Employee addEmployee(EmpValidation empValidation) {
       Employee employee =
               Employee.build(empValidation.getEid(),empValidation.getEname(),empValidation.getEemail(),empValidation.getEmob(),empValidation.getEsalary());

       return emprepo.save(employee);
   }

//    @Override
//    public Employee addEmployee(Employee emp) {
//        Employee employee = emprepo.save(emp);
//        return employee;
//    }

    @Override
    public String removeEmployee(int id) {

        emprepo.deleteById(id);
        return "employee deleted successfully";
    }

    @Override
    public Optional<Employee> findEmpByID(int id) {

        Optional<Employee> emp = emprepo.findById(id);
        if(emp.isPresent())
            return emp;
        else
            return null;

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> emp = emprepo.findAll();
        return emp;
    }

    @Override
    public Employee updateEmployee(EmpValidation emp) {

        Optional<Employee> empdb = this.emprepo.findById(emp.getEid());
        Employee empUpdt = empdb.get();
        if(empdb.isPresent()){
            System.out.println("in if "+empdb.isPresent());

            empUpdt.setEid(emp.getEid());
            empUpdt.setEemail(emp.getEemail());
            empUpdt.setEmob(emp.getEmob());
            empUpdt.setEname(emp.getEname());
            empUpdt.setEsalary(emp.getEsalary());

        }
        return empUpdt;
    }
}
