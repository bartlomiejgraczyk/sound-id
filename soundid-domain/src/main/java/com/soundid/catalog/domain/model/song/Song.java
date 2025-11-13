package com.soundid.catalog.domain.model.song;

import com.soundid.catalog.domain.model.album.AlbumId;
import com.soundid.catalog.domain.model.artist.ArtistId;
import org.jspecify.annotations.NonNull;

public record Song(
    @NonNull SongId id,
    @NonNull String title,
    @NonNull ArtistId artistId,
    @NonNull AlbumId albumId
) {
    public Song {
        if (id == null) {
            throw new IllegalArgumentException("SongId cannot be null");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Song title cannot be null or blank");
        }
        if (artistId == null) {
            throw new IllegalArgumentException("ArtistId cannot be null");
        }
        if (albumId == null) {
            throw new IllegalArgumentException("AlbumId cannot be null");
        }
    }
}
