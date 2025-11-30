package com.soundid.catalog.application.ingestion;

import com.soundid.catalog.domain.model.fingerprint.Fingerprint;
import com.soundid.catalog.domain.model.song.Song;
import com.soundid.catalog.domain.model.song.SongId;
import com.soundid.catalog.domain.repository.FingerprintRepository;
import com.soundid.catalog.domain.repository.SongRepository;
import com.soundid.catalog.domain.service.FingerprintingService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;

@RequiredArgsConstructor
public class IngestSongUseCase {

    private final SongRepository songRepository;
    private final FingerprintRepository fingerprintRepository;
    private final FingerprintingService fingerprintingService;

    public SongId handle(@NonNull IngestSongCommand command) {
        Song song = new Song(
            SongId.generate(),
            command.title()
        );
        Set<Fingerprint> fingerprints = fingerprintingService.generateFingerprints(
            command.audioSample()
        );
        songRepository.save(song);
        fingerprintRepository.saveAll(song.id(), fingerprints); // TODO: perform both saves in a transaction
        return song.id();
    }
}
