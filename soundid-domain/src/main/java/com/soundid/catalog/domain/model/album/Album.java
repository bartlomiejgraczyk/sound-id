package com.soundid.catalog.domain.model.album;

import com.soundid.catalog.domain.model.artist.ArtistId;
import org.jspecify.annotations.NonNull;

public record Album(
    @NonNull AlbumId id,
    @NonNull String name,
    @NonNull ArtistId artistId
) {

    public Album {
        if (id == null) {
            throw new IllegalArgumentException("AlbumId cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Album name cannot be null or blank");
        }
        if (artistId == null) {
            throw new IllegalArgumentException("ArtistId cannot be null");
        }
    }
}
