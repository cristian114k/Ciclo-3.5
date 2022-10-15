package com.api.ciclo3.mt.Ciclo3.controllers;

import com.api.ciclo3.mt.Ciclo3.models.Reservation;
import com.api.ciclo3.mt.Ciclo3.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return  reservationService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Reservation> getReservation(@PathVariable("id")int id) {
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r) {
        return reservationService.save(r);
    }
}
