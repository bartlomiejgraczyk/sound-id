package com.soundid.catalog.infrastructure.persistence.inmemory;

import com.soundid.catalog.domain.model.song.Song;
import com.soundid.catalog.domain.model.song.SongId;
import com.soundid.catalog.domain.repository.SongRepository;
import java.util.Optional;
import org.jspecify.annotations.NonNull;

public class InMemorySongRepository implements SongRepository {
    @Override
    public void save(@NonNull Song song) {

    }

    @Override
    public Optional<Song> findById(@NonNull SongId songId) {
        return Optional.empty();
    }
}
