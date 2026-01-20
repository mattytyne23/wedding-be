package com.example.rsvp.controller;

import com.example.rsvp.exception.DuplicateRsvpException;
import com.example.rsvp.exception.RsvpNotFoundException;
import com.example.rsvp.model.Rsvp;
import com.example.rsvp.repository.RsvpRepository;
import com.example.rsvp.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rsvps")
@CrossOrigin(origins = "*")
public class RsvpController {

    private final RsvpRepository repository;
    private final EmailService emailService;

    public RsvpController(RsvpRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @GetMapping
    public List<Rsvp> getAllRsvps() {
        return repository.findAll();
    }

    @PostMapping("/batch")
    public List<Rsvp> createMultipleRsvps(@RequestBody List<Rsvp> rsvps) {

        // Extract names from incoming payload
        List<String> incomingNames = rsvps.stream()
                .map(r -> r.getName().trim())
                .toList();

        // Find existing RSVPs with those names
        List<Rsvp> existing = repository.findByNameIn(incomingNames);

        if (!existing.isEmpty()) {
            List<String> duplicateNames = existing.stream()
                    .map(Rsvp::getName)
                    .toList();

            throw new DuplicateRsvpException(duplicateNames);
        }

        return repository.saveAll(rsvps);
    }

    @GetMapping(params = "name")
    public Rsvp getRsvpByName(@RequestParam String name) {
        return repository.findByName(name.trim())
                .orElseThrow(() -> new RsvpNotFoundException(name));
    }


    @PostMapping("/process")
    public ResponseEntity<String> process() {

        // business logic

        emailService.sendSuccessEmail(
                "user@example.com",
                "Your request was successful"
        );

        return ResponseEntity.ok("Success");
    }

    @PostMapping
    public Rsvp createRsvp(@RequestBody Rsvp rsvp) {
        return repository.save(rsvp);
    }
}
