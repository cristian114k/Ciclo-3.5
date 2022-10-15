package com.api.ciclo3.mt.Ciclo3.services;

import com.api.ciclo3.mt.Ciclo3.models.Admin;
import com.api.ciclo3.mt.Ciclo3.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin obj){
        if(obj.getId() == null){
            return adminRepository.save( obj );
        }
        else {
            return obj;
        }
    }

    public Admin update(Admin obj){
        if(obj.getId() != null){
            Optional<Admin> temp = adminRepository.getAdmin(obj.getId());
            if(!temp.isEmpty()) {
                return adminRepository.save(obj);
            }
            else {
                return obj;
            }
        }
        else {
            return obj;
        }
    }

    public Boolean delete(int id){
        Boolean b = false;
        Optional<Admin> temp = adminRepository.getAdmin(id);
        if(!temp.isEmpty()) {
            adminRepository.delete(id);
            b=true;
        }
        return b;
    }
}
