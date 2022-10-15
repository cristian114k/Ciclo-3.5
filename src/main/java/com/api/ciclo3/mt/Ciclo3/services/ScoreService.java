package com.api.ciclo3.mt.Ciclo3.services;

import com.api.ciclo3.mt.Ciclo3.models.Score;
import com.api.ciclo3.mt.Ciclo3.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return  scoreRepository.getScore(id);
    }

    public Score save(Score p){
        if(p.getId() == null){
            return scoreRepository.save(p);
        }else{
            Optional<Score> scoreOptional = scoreRepository.getScore(p.getId());
            if(scoreOptional.isEmpty()){
                return scoreRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Score update(Score r){
        if(r.getId()!=null){
            Optional<Score>g=scoreRepository.getScore(r.getId());
            if(!g.isEmpty()){
                if(r.getScore()!=null){
                    g.get().setScore(r.getScore());
                }
                if(r.getReservation() !=null){
                    g.get().setReservation(r.getReservation());
                }
                return scoreRepository.save(g.get());
            }
        }
        return r;
    }

    public boolean deleteScore(int id){
        Optional<Score> c = getScore(id);
        if(!c.isEmpty()){
            scoreRepository.delete((c.get()));
            return true;
        }
        return false;
    }
}
