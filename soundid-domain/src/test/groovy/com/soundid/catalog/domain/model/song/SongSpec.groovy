package com.soundid.catalog.domain.model.song

import spock.lang.Specification
import spock.lang.Unroll

class SongSpec extends Specification {
    private static final SongId SONG_ID = new SongId("song-id")
    private static final String SONG_TITLE = "Song Title"

    def "should create Song correctly with valid data"() {
        when:
        def song = new Song(SONG_ID, SONG_TITLE)

        then:
        song.id() == SONG_ID
        song.title() == SONG_TITLE
    }

    @Unroll
    def "should throw exception when #scenario"() {
        when:
        new Song(id, title)

        then:
        thrown IllegalArgumentException

        where:
        scenario         | id      | title
        "id is null"     | null    | SONG_TITLE
        "title is null"  | SONG_ID | null
        "title is empty" | SONG_ID | ""
        "title is blank" | SONG_ID | "   "
    }
}