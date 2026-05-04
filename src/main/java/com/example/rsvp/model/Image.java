package com.example.rsvp.model;

import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String publicId;
    private String url;

    // optional but useful
    private String originalFilename;

    public void setPublicId(String publicId) {
    }

    public void setUrl(String url) {
    }

    public void setOriginalFilename(String originalFilename) {
    }

    // getters & setters
}
