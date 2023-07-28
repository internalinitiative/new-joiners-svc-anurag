package com.example.GitHubCopilot.Service;

import com.example.GitHubCopilot.DtoValidator.MgrValidation;
import com.example.GitHubCopilot.Model.Employee;
import com.example.GitHubCopilot.Model.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {

    Manager addManager(MgrValidation mgr);
    String removeManager(int id);
    Optional<Manager> findManagerByID(int id);
    List<Manager> getAllManager();
    Optional<Manager> updateManager(MgrValidation mgr);
}
