package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Admin;
import edu.cesi.cube4.model.House;
import edu.cesi.cube4.repository.AdminRepo;
import edu.cesi.cube4.repository.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public List<Admin> findAllAdmins() {

        List<Admin> adminList = adminRepo.findAll();
        adminList.forEach(admin -> admin.setPassword(null));
        return adminList;

    }

    public Optional<Admin> findAdminById(Integer id) {
        return adminRepo.findById(id);
    }

    public Optional<Admin> findAdminByUsername(String username) {
        return adminRepo.findByUsername(username);
    }

}
