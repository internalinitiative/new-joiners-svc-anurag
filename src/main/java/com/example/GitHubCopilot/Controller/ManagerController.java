package com.example.GitHubCopilot.Controller;

import com.example.GitHubCopilot.DtoValidator.MgrValidation;
import com.example.GitHubCopilot.Model.Employee;
import com.example.GitHubCopilot.Model.Manager;
import com.example.GitHubCopilot.ServiceImpl.ManagerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mgr")
public class ManagerController {

    @Autowired
    private ManagerServiceImpl managerservice;

    @RequestMapping("/home")
    public String homepage() {

        return "welcome to Manager home page";
    }

    @PostMapping("/manager")
    public ResponseEntity<Manager> addManager(@RequestBody @Valid MgrValidation manager){

        Manager mgr = managerservice.addManager(manager);

        return new ResponseEntity<>(mgr, HttpStatus.CREATED);
    }

    @DeleteMapping("/removemgr/{id}")
    public ResponseEntity<String> removeManager(@PathVariable int id){

        managerservice.removeManager(id);
        return new ResponseEntity<String>("Remove Manager successfully",HttpStatus.ACCEPTED);
    }

    @GetMapping("/getmgr/{id}")
    public ResponseEntity<Optional<Manager>> findMgrById(@PathVariable int id){

        Optional<Manager> mgrByID = managerservice.findManagerByID(id);

        return new ResponseEntity<Optional<Manager>>(mgrByID,HttpStatus.ACCEPTED);

    }

    @GetMapping("/managers")
    public ResponseEntity<List<Manager>> listOfManager(){
        List<Manager> allManager = managerservice.getAllManager();

        return new ResponseEntity<List<Manager>>(allManager,HttpStatus.ACCEPTED);
    }

    @PutMapping("/updatemgr/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable int id,@RequestBody @Valid MgrValidation manager){

        manager.setMid(id);

        Manager updtMgr = managerservice.updateManager(manager);

        return new ResponseEntity<>(updtMgr,HttpStatus.OK);
    }
}
