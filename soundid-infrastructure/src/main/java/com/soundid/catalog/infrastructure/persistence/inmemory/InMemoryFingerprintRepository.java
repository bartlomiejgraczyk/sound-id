package com.soundid.catalog.infrastructure.persistence.inmemory;

import com.soundid.catalog.domain.model.fingerprint.Fingerprint;
import com.soundid.catalog.domain.model.song.SongId;
import com.soundid.catalog.domain.repository.FingerprintRepository;
import java.util.Set;
import org.jspecify.annotations.NonNull;

public class InMemoryFingerprintRepository implements FingerprintRepository {
    @Override
    public void saveAll(@NonNull SongId songId, @NonNull Set<Fingerprint> fingerprints) {

    }
}
