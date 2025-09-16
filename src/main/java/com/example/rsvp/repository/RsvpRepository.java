package com.example.rsvp.repository;

import com.example.rsvp.model.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RsvpRepository extends JpaRepository<Rsvp, Long> {}
