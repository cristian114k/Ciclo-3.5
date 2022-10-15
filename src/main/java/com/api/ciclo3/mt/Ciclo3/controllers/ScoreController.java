package com.api.ciclo3.mt.Ciclo3.controllers;

import com.api.ciclo3.mt.Ciclo3.models.Score;
import com.api.ciclo3.mt.Ciclo3.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll() {
        return  scoreService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Score> getScore(@PathVariable("id")int id) {
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score o) {
        return scoreService.save(o);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score r){
        return scoreService.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id")int id){
        return scoreService.deleteScore(id);
    }
}
