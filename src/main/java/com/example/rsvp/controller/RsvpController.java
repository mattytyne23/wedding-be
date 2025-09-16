package com.example.rsvp.controller;

import com.example.rsvp.model.Rsvp;
import com.example.rsvp.repository.RsvpRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rsvps")
@CrossOrigin(origins = "*")
public class RsvpController {

    private final RsvpRepository repository;

    public RsvpController(RsvpRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Rsvp> getAllRsvps() {
        return repository.findAll();
    }

    @PostMapping
    public Rsvp createRsvp(@RequestBody Rsvp rsvp) {
        return repository.save(rsvp);
    }
}
