package com.soundid.catalog.application.ingestion;

import com.soundid.catalog.domain.model.fingerprint.AudioSample;
import org.jspecify.annotations.NonNull;

public record IngestSongCommand(
    @NonNull String title,
    @NonNull AudioSample audioSample
) {

    public IngestSongCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        if (audioSample == null) {
            throw new IllegalArgumentException("AudioSample cannot be null");
        }
    }
}