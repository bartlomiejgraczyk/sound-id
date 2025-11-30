package com.soundid.catalog.domain.model.song

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

@CompileStatic
@Builder(builderStrategy = SimpleStrategy, prefix = "with")
class SongBuilder {
    String id = "default-song-id"
    String title = "Default Song Title"

    static SongBuilder aSong() {
        return new SongBuilder()
    }

    Song build() {
        return new Song(
                new SongId(id),
                title
        )
    }
}
