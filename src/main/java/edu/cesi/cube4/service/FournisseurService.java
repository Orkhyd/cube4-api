package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Fournisseur;
import edu.cesi.cube4.repository.FournisseurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {
    private final FournisseurRepo fournisseurRepo;

    @Autowired
    public FournisseurService(FournisseurRepo fournisseurRepo) {
        this.fournisseurRepo = fournisseurRepo;
    }

    public List<Fournisseur> findAllSuppliers() {
        return fournisseurRepo.findAll();
    }

    public  Fournisseur saveSupplier(Fournisseur Fournisseur) {
        return fournisseurRepo.save(Fournisseur);
    }

}
