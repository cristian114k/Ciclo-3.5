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

    public Ortopedic update(Ortopedic o){
        if(o.getId()!=null){
            Optional<Ortopedic>g=ortopedicRepository.getOrtopedic(o.getId());
            if(!g.isEmpty()){
                if(o.getName()!=null){
                    g.get().setName(o.getName());
                }
                if(o.getBrand() !=null){
                    g.get().setBrand(o.getBrand());
                }
                if(o.getYear() !=null){
                    g.get().setYear(o.getYear());
                }
                if(o.getDescription() !=null){
                    g.get().setDescription(o.getDescription());
                }
                return ortopedicRepository.save(g.get());
            }
        }
        return o;
    }

    public boolean deleteOrtopedic(int id){
        Optional<Ortopedic> c = getOrtopedic(id);
        if(!c.isEmpty()){
            ortopedicRepository.delete((c.get()));
            return true;
        }
        return false;
    }

}