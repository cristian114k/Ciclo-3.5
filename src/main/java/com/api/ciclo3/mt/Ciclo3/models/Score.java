package com.api.ciclo3.mt.Ciclo3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer Score;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer valueScore) {
        this.Score = valueScore;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservations) {
        this.reservation = reservations;
    }
}