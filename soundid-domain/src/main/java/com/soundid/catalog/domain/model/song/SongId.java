package com.soundid.catalog.domain.model.song;

import java.util.UUID;
import org.jspecify.annotations.NonNull;

public record SongId(@NonNull String value) {
    public SongId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("SongId cannot be null or blank");
        }
    }

    public static SongId generate() {
        return new SongId(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
