package com.example.rsvp.service;
import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public List<String> getAllPublicIds() throws Exception {
        Map result = cloudinary.api().resources(Map.of(
                "type", "upload",
                "max_results", 50
        ));

        List<Map> resources = (List<Map>) result.get("resources");

        return resources.stream()
                .map(resource -> (String) resource.get("public_id"))
                .collect(Collectors.toList());
    }

    public String generateGridImageUrl(String publicId) {
        return cloudinary.url()
                .transformation(new Transformation()
                        .width(100)
                        .height(100)
                        .crop("fill")
                        .gravity("auto")
                        .quality("auto")
                        .fetchFormat("auto"))
                .generate(publicId);
    }

    public List<Map> getAllImages() throws Exception {
        List<Map> allImages = new ArrayList<>();
        String nextCursor = null;

        do {
            Map<String, Object> params = new HashMap<>();
            params.put("resource_type", "image");
            params.put("max_results", 500);

            if (nextCursor != null) {
                params.put("next_cursor", nextCursor);
            }

            Map result = cloudinary.api().resources(params);

            List<Map> resources = (List<Map>) result.get("resources");
            allImages.addAll(resources);

            nextCursor = (String) result.get("next_cursor");

        } while (nextCursor != null);

        return allImages;
    }
}
