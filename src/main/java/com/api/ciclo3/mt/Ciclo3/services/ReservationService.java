package com.api.ciclo3.mt.Ciclo3.services;

import com.api.ciclo3.mt.Ciclo3.models.Reservation;
import com.api.ciclo3.mt.Ciclo3.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return  reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation p){
        if(p.getIdReservation() == null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> reservationOptional = reservationRepository.getReservation(p.getIdReservation());
            if(reservationOptional.isEmpty()){
                return reservationRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Reservation update(Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation>g=reservationRepository.getReservation(r.getIdReservation());
            if(!g.isEmpty()){
                if(r.getStartDate()!=null){
                    g.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate() !=null){
                    g.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus() != null){
                    g.get().setStatus(r.getStatus());
                }
                if(r.getScore() !=null){
                    g.get().setScore(r.getScore());
                }
                return reservationRepository.save(g.get());
            }
        }
        return r;
    }

    public boolean deleteReservation(int id){
        Optional<Reservation> c = getReservation(id);
        if(!c.isEmpty()){
            reservationRepository.delete((c.get()));
            return true;
        }
        return false;
    }
}
