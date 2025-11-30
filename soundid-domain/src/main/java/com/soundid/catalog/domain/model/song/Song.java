package com.soundid.catalog.domain.model.song;

import org.jspecify.annotations.NonNull;

public record Song(
    @NonNull SongId id,
    @NonNull String title
) {
    public Song {
        if (id == null) {
            throw new IllegalArgumentException("SongId cannot be null");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Song title cannot be null or blank");
        }
    }
}
