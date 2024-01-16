package edu.cesi.cube4.service;

import edu.cesi.cube4.model.SupplierOrder;
import edu.cesi.cube4.repository.SupplierOrderRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierOrderService {
    private final SupplierOrderRepo supplierOrderRepo;

    public SupplierOrderService(SupplierOrderRepo supplierOrderRepo) {
        this.supplierOrderRepo = supplierOrderRepo;
    }

    public Optional<SupplierOrder> findSupplierOrderById(Integer id){
        return supplierOrderRepo.findById(id);
    }

    public SupplierOrder saveSupplierOrder(SupplierOrder supplierOrder){
        return supplierOrderRepo.save(supplierOrder);
    }
}
