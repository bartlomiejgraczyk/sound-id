package com.soundid.catalog.infrastructure.persistence.inmemory;

import com.soundid.catalog.domain.model.fingerprint.Fingerprint;
import com.soundid.catalog.domain.model.song.SongId;
import com.soundid.catalog.domain.repository.FingerprintRepository;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jspecify.annotations.NonNull;

public class InMemoryFingerprintRepository implements FingerprintRepository {

    private final Map<SongId, Set<Fingerprint>> database = new ConcurrentHashMap<>();

    @Override
    public void saveAll(@NonNull SongId songId, @NonNull Set<Fingerprint> fingerprints) {
        Set<Fingerprint> immutableFingerprints = Set.copyOf(fingerprints);
        database.put(songId, immutableFingerprints);
    }

    public Set<Fingerprint> findBySongId(@NonNull SongId songId) {
        return database.getOrDefault(songId, Collections.emptySet());
    }
}