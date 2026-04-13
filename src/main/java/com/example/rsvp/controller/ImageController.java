package com.example.rsvp.controller;
import com.example.rsvp.service.CloudinaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*") // adjust for production
public class ImageController {

    private final CloudinaryService service;

    public ImageController(CloudinaryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Map> getImages() throws Exception {
        return service.getAllImages();
    }

    @GetMapping("/grid")
    public List<String> getGridImages() throws Exception {
        return service.getAllPublicIds().stream()
                .map(service::generateGridImageUrl)
                .toList();
    }
}
