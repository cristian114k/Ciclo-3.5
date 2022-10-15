package com.api.ciclo3.mt.Ciclo3.services;

import com.api.ciclo3.mt.Ciclo3.models.CountClient;
import com.api.ciclo3.mt.Ciclo3.models.DescriptionAmount;
import com.api.ciclo3.mt.Ciclo3.models.Reservation;
import com.api.ciclo3.mt.Ciclo3.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public DescriptionAmount getStatusReport(){
        List<Reservation> completed = reservationRepository.getClientsByDescription("completed");
        List<Reservation> cancelled = reservationRepository.getClientsByDescription("cancelled");

        DescriptionAmount descAmount = new DescriptionAmount(completed.size(), cancelled.size());
        return descAmount;
    }


    public List<Reservation> getReservationsPeriod(String d1, String d2){

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try {
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        }else {
            return new ArrayList<>();
        }
    }
}
