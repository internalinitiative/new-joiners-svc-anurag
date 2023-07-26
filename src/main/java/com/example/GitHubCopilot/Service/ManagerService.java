package com.example.GitHubCopilot.Service;

import com.example.GitHubCopilot.DtoValidator.MgrValidation;
import com.example.GitHubCopilot.Model.Employee;
import com.example.GitHubCopilot.Model.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {

    public Manager addManager(MgrValidation mgr);
    public String removeManager(int id);
    public Optional<Manager> findManagerByID(int id);
    public List<Manager> getAllManager();
    public Manager updateManager(MgrValidation mgr);
}
