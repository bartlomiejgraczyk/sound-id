package com.soundid.catalog.domain.model.artist;

import org.jspecify.annotations.NonNull;

public record Artist(
    @NonNull ArtistId id,
    @NonNull String name
) {

    public Artist {
        if (id == null) {
            throw new IllegalArgumentException("ArtistId cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Artist name cannot be null or blank");
        }
    }
}
