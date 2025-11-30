package com.soundid.catalog.domain.repository;

import com.soundid.catalog.domain.model.fingerprint.Fingerprint;
import com.soundid.catalog.domain.model.song.SongId;
import java.util.Set;
import org.jspecify.annotations.NonNull;

public interface FingerprintRepository {

    void saveAll(@NonNull SongId songId, @NonNull Set<Fingerprint> fingerprints);
}