package com.example.rsvp.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        String cloudinaryUrl = System.getenv("CLOUDINARY_URL");
        System.out.println("CLOUDINARY_URL = " + cloudinaryUrl);
        return new Cloudinary(cloudinaryUrl);
    }
}
