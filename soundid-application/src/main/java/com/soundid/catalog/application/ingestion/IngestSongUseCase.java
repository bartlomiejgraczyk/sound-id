package com.soundid.catalog.application.ingestion;

import com.soundid.catalog.domain.model.song.SongId;
import com.soundid.catalog.domain.repository.FingerprintRepository;
import com.soundid.catalog.domain.repository.SongRepository;
import com.soundid.catalog.domain.service.FingerprintingService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;

@RequiredArgsConstructor
public class IngestSongUseCase {

    private final SongRepository songRepository;
    private final FingerprintRepository fingerprintRepository;
    private final FingerprintingService fingerprintingService;

    public SongId handle(@NonNull IngestSongCommand command) {
        return null;
    }
}
