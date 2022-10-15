package com.api.ciclo3.mt.Ciclo3.services;

import com.api.ciclo3.mt.Ciclo3.models.Ortopedic;
import com.api.ciclo3.mt.Ciclo3.repositories.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrtopedicService {

    @Autowired
    private OrtopedicRepository ortopedicRepository;

    public List<Ortopedic> getAll() {
        return ortopedicRepository.getAll();
    }

    public Optional<Ortopedic> getOrtopedic(int id) {
        return  ortopedicRepository.getOrtopedic(id);
    }

    public Ortopedic save(Ortopedic p){
        if(p.getId() == null){
            return ortopedicRepository.save(p);
        }else{
            Optional<Ortopedic> ortopedicOptional = ortopedicRepository.getOrtopedic(p.getId());
            if(ortopedicOptional.isEmpty()){
                return ortopedicRepository.save(p);
            }else{
                return p;
            }
        }
    }
}