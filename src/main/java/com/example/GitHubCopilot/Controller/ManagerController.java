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
import com.example.GitHubCopilot.Service.ManagerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService){
        this.managerService=managerService;
    }

    @RequestMapping("/home")
    public String homepage() {

        return "welcome to Manager home page";
    }

    @PostMapping
    public ResponseEntity<Manager> addManager(@RequestBody @Valid MgrValidation manager){

        Manager mgr = managerService.addManager(manager);

        return new ResponseEntity<>(mgr, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeManager(@PathVariable int id){

        managerService.removeManager(id);
        return new ResponseEntity<String>("Remove Manager successfully",HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Manager>> findMgrById(@PathVariable int id){

        Optional<Manager> mgrByID = managerService.findManagerByID(id);

        return new ResponseEntity<Optional<Manager>>(mgrByID,HttpStatus.ACCEPTED);

    }

    @GetMapping
    public ResponseEntity<List<Manager>> listOfManager(){
        List<Manager> allManager = managerService.getAllManager();

        return new ResponseEntity<List<Manager>>(allManager,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Manager>> updateManager(@PathVariable int id,@RequestBody @Valid MgrValidation manager){

        manager.setId(id);

        Optional<Manager> updtMgr = managerService.updateManager(manager);

        return new ResponseEntity<>(updtMgr,HttpStatus.OK);
    }
}
