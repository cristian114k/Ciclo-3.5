package com.api.ciclo3.mt.Ciclo3.repositories;


import com.api.ciclo3.mt.Ciclo3.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCRUDRepository adminCRUDRepository;

    public List<Admin> getAll(){
        return(List<Admin>) adminCRUDRepository.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return (Optional<Admin>)adminCRUDRepository.findById(id);
    }

    public Admin save(Admin c) {
        return (Admin) adminCRUDRepository.save(c);
    }

    public  void delete(int id) {
        adminCRUDRepository.deleteById(id);
    }
}
