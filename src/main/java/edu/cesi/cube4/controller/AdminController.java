package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Admin;
import edu.cesi.cube4.model.House;
import edu.cesi.cube4.service.AdminService;
import edu.cesi.cube4.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.findAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Integer id){
        Optional<Admin> optional = adminService.findAdminById(id);
        if (optional.isPresent()) {
            optional.get().setPassword(null);
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id, @RequestBody Admin modAdmin) {
        Optional<Admin> optional = adminService.findAdminById(id);
        if (optional.isPresent()) {
            adminService.saveAdmin(modAdmin);
            return new ResponseEntity<>(modAdmin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
