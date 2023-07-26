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

    @Autowired
    private ManagerRepo managerRepo;

    @Override
    public Manager addManager(MgrValidation mgrValidation) {
        Manager manager =
                Manager.build(mgrValidation.getMid(),mgrValidation.getMname(),mgrValidation.getMemail(),mgrValidation.getMmob(),mgrValidation.getMdepartment());

        return managerRepo.save(manager);
    }

    @Override
    public String removeManager(int id) {

        managerRepo.deleteById(id);
        return "manager is deleted successfully";
    }

    @Override
    public Optional<Manager> findManagerByID(int id) {
        Optional<Manager> findMgrById = managerRepo.findById(id);
        return findMgrById;
    }

    @Override
    public List<Manager> getAllManager() {
        List<Manager> listOfMgr = managerRepo.findAll();
        return listOfMgr;
    }

    @Override
    public Manager updateManager(MgrValidation mgr) {
        Optional<Manager> mgrdb = this.managerRepo.findById(mgr.getMid());
        Manager mgrUpdt = mgrdb.get();

        if(mgrdb.isPresent()){
            mgrUpdt.setMid(mgr.getMid());
            mgrUpdt.setMemail(mgr.getMemail());
            mgrUpdt.setMname(mgr.getMname());
            mgrUpdt.setMmob(mgr.getMmob());
            mgrUpdt.setMdepartment(mgr.getMdepartment());
        }
        return mgrUpdt;
    }
}
