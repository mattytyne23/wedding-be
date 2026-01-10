package com.example.rsvp.repository;

import com.example.rsvp.model.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RsvpRepository extends JpaRepository<Rsvp, Long> {
    List<Rsvp> findByNameIn(List<String> names);
}
