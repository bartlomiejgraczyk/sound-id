package com.soundid.catalog.infrastructure.persistence.inmemory;

import com.soundid.catalog.domain.model.song.Song;
import com.soundid.catalog.domain.model.song.SongId;
import com.soundid.catalog.domain.repository.SongRepository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.jspecify.annotations.NonNull;

public class InMemorySongRepository implements SongRepository {

    private final Map<SongId, Song> database = new ConcurrentHashMap<>();

    @Override
    public void save(@NonNull Song song) {
        database.put(song.id(), song);
    }

    @Override
    public Optional<Song> findById(@NonNull SongId songId) {
        return Optional.ofNullable(database.get(songId));
    }
}