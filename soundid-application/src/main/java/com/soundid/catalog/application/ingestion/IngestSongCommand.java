package com.soundid.catalog.application.ingestion;

import com.soundid.catalog.domain.model.fingerprint.AudioSample;
import org.jspecify.annotations.NonNull;

public record IngestSongCommand(
    @NonNull String title,
    @NonNull String artistName,
    @NonNull String albumName,
    @NonNull AudioSample audioSample
) {

    public IngestSongCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        if (artistName == null || artistName.isBlank()) {
            throw new IllegalArgumentException("Artist name cannot be blank");
        }
        if (albumName == null || albumName.isBlank()) {
            throw new IllegalArgumentException("Album name cannot be blank");
        }
        if (audioSample == null) {
            throw new IllegalArgumentException("AudioSample cannot be null");
        }
    }
}