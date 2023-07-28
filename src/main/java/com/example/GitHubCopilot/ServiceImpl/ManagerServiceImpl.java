package com.example.GitHubCopilot.ServiceImpl;

import com.example.GitHubCopilot.DtoValidator.MgrValidation;
import com.example.GitHubCopilot.Model.Manager;
import com.example.GitHubCopilot.Repository.ManagerRepo;
import com.example.GitHubCopilot.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepo managerRepo;
    @Autowired
    public ManagerServiceImpl(ManagerRepo managerRepo){
        this.managerRepo=managerRepo;
    }

    @Override
    public Manager addManager(MgrValidation mgrValidation) {
        Manager manager =
                Manager.build(mgrValidation.getId(),mgrValidation.getName(),mgrValidation.getEmail(),mgrValidation.getMobile(),mgrValidation.getDepartment());

        return managerRepo.save(manager);
    }

    @Override
    public String removeManager(int id) {

        managerRepo.deleteById(id);
        return "manager is deleted successfully";
    }

    @Override
    public Optional<Manager> findManagerByID(int id) {
        Optional<Manager> manager = managerRepo.findById(id);
        return manager;
    }

    @Override
    public List<Manager> getAllManager() {
        List<Manager> managers = managerRepo.findAll();
        return managers;
    }

    @Override
    public Optional<Manager> updateManager(MgrValidation mgr) {
        Optional<Manager> mgrdb = this.managerRepo.findById(mgr.getId());

        if(mgrdb.isPresent()){
            Manager mgrUpdt = mgrdb.get();
            mgrUpdt.setId(mgr.getId());
            mgrUpdt.setEmail(mgr.getEmail());
            mgrUpdt.setName(mgr.getName());
            mgrUpdt.setMobile(mgr.getMobile());
            mgrUpdt.setDepartment(mgr.getDepartment());
            return Optional.of(managerRepo.save(mgrUpdt));
        }
           return Optional.empty();
    }
}
