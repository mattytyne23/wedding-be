package com.example.rsvp.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Value("${cloudinary.cloud-name:}")
    private String cloudName;

    @Value("${cloudinary.api-key:}")
    private String apiKey;

    @Value("${cloudinary.api-secret:}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {
        String cloudinaryUrl = System.getenv("CLOUDINARY_URL");

        if (cloudinaryUrl == null || cloudinaryUrl.isBlank()) {
            throw new IllegalStateException("CLOUDINARY_URL is not set in environment");
        }
        // ✅ Prefer env var (production)
        if (cloudinaryUrl != null && !cloudinaryUrl.isBlank()) {
            return new Cloudinary(cloudinaryUrl);
        }

        // ✅ Fallback to properties (local)
        if (!cloudName.isBlank() && !apiKey.isBlank() && !apiSecret.isBlank()) {
            return new Cloudinary(ObjectUtils.asMap(
                    "dtojs0fca", cloudName,
                    "123376546923981", apiKey,
                    "KXedsv4tOPMfjUAgBM6ylIu_wdk", apiSecret
            ));
        }

        // ❌ Fail fast if nothing is configured
        throw new IllegalStateException(
                "Cloudinary configuration missing. Set CLOUDINARY_URL or application properties."
        );
    }
}