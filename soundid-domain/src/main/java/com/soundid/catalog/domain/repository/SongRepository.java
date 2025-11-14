package com.soundid.catalog.domain.repository;

import com.soundid.catalog.domain.model.song.Song;
import com.soundid.catalog.domain.model.song.SongId;
import java.util.Optional;
import org.jspecify.annotations.NonNull;

public interface SongRepository {

    void save(@NonNull Song song);

    Optional<Song> findById(@NonNull SongId songId);
}