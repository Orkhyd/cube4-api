package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Supplier;
import edu.cesi.cube4.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepo supplierRepo;

    @Autowired
    public SupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    public List<Supplier> findAllSuppliers() {
        return supplierRepo.findAll();
    }

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

}
