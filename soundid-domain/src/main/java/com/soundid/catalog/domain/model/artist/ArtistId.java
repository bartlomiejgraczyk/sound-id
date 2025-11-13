package com.soundid.catalog.domain.model.artist;

import java.util.UUID;
import org.jspecify.annotations.NonNull;

public record ArtistId(@NonNull  String value) {

    public ArtistId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ArtistId cannot be null or blank");
        }
    }

    public static ArtistId generate() {
        return new ArtistId(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
