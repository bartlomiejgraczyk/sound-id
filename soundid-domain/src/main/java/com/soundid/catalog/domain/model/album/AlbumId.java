package com.soundid.catalog.domain.model.album;

import java.util.UUID;
import org.jspecify.annotations.NonNull;

public record AlbumId(@NonNull String value) {
    public AlbumId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("AlbumId cannot be null or blank");
        }
    }

    public static AlbumId generate() {
        return new AlbumId(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
