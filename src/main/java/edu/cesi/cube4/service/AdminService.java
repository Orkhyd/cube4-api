package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Admin;
import edu.cesi.cube4.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<List<Admin>> findAllAdmins() {
        List<Admin> adminList = adminRepo.findAll();
        if (!adminList.isEmpty()) {
            adminList.forEach(admin -> admin.setPassword(null));
            return new ResponseEntity<>(adminList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Admin> findAdminById(Integer id) {
        Optional<Admin> optionalAdmin = adminRepo.findById(id);
        if (optionalAdmin.isPresent()) {
            optionalAdmin.get().setPassword(null);
            return new ResponseEntity<>(optionalAdmin.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Admin> findAdminByUsername(String username) {
        Optional<Admin> optionalAdmin = adminRepo.findByUsername(username);
        if (optionalAdmin.isPresent()) {
            optionalAdmin.get().setPassword(null);
            return new ResponseEntity<>(optionalAdmin.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Admin> updateAdmin(Integer id, Admin modAdmin) {
        Optional<Admin> optional = adminRepo.findById(id);
        if (optional.isPresent()) {
            Admin savedAdmin = saveAdmin(modAdmin);
            return new ResponseEntity<>(savedAdmin, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
