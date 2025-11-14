package com.soundid.catalog.infrastructure.persistence.inmemory

import com.soundid.catalog.domain.model.song.Song
import com.soundid.catalog.domain.model.song.SongId
import spock.lang.Specification

import static com.soundid.catalog.domain.model.song.SongAssertions.assertThat
import static com.soundid.catalog.domain.model.song.SongBuilder.aSong

class InMemorySongRepositorySpec extends Specification {
    private static final def SONG_ID_1 = "SONG_ID_1"
    private static final def SONG_TITLE_1 = "Test Song Title 1"
    private static final def SONG_TITLE_2 = "Test Song Title 2"

    private InMemorySongRepository repository

    def setup() {
        repository = new InMemorySongRepository()
    }

    def "should save a song and find it by id"() {
        given:
        def song = aSong()
                .withId(SONG_ID_1)
                .withTitle(SONG_TITLE_1)
                .build()

        when:
        repository.save(song)

        and:
        def foundSong = findById(SONG_ID_1)

        then:
        foundSong.isPresent()
        foundSong.get() == song
    }

    def "should return empty optional if song is not found"() {
        given:
        def randomId = SongId.generate()

        when:
        def foundSongOptional = repository.findById(new SongId(SONG_ID_1))

        then:
        foundSongOptional.isEmpty()
    }

    def "should update (upsert) a song if save is called with existing ID"() {
        given:
        def originalSong = aSong().withId(SONG_ID_1).withTitle(SONG_TITLE_1).build()
        repository.save(originalSong)

        when:
        def updatedSong = aSong().withId(SONG_ID_1).withTitle(SONG_TITLE_2).build()
        repository.save(updatedSong)

        and:
        def foundSong = findById(SONG_ID_1)

        then:
        foundSong.isPresent()
        assertThat(foundSong.get())
                .hasId(SONG_ID_1)
                .hasTitle(SONG_TITLE_2)
        foundSong.get() == updatedSong
    }

    private Optional<Song> findById(String id) {
        return repository.findById(new SongId(id))
    }
}