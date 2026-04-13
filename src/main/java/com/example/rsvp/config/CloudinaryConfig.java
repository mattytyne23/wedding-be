package com.example.rsvp.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dtojs0fca");
        config.put("api_key", "123376546923981");
        config.put("api_secret", "KXedsv4tOPMfjUAgBM6ylIu_wdk");
        return new Cloudinary(config);
    }
}
